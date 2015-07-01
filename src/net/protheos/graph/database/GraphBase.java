/**
 * Project: Beta001
 * Package: net.protheos.graph.database
 * Filename: GraphBase.java
 * Date: 1 de jul de 2015
 * Time: 14:23:59
 * Developer: Marcelo Gagliano
 */
package net.protheos.graph.database;

/*
 * Licensed to Neo Technology under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Neo Technology licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Vector;

import net.protheos.nlp.Sentence;

import org.neo4j.cypher.export.DatabaseSubGraph;
import org.neo4j.cypher.export.SubGraphExporter;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Path;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.traversal.Evaluators;
import org.neo4j.graphdb.traversal.TraversalDescription;
import org.neo4j.graphdb.traversal.Traverser;
import org.neo4j.io.fs.FileUtils;


public class GraphBase {
	int counter = 0;
	public enum RelTypes implements RelationshipType {
		IS,
		ARE
	}

	private static final String GRAPH_DB = "target/graphbase";
	private static GraphDatabaseService graphDb;
	private static long nodeID;

	public static void main(String[] args) throws IOException {
		Sentence s = new Sentence();
		s.tokenize("SOCRATES IS MAN");

		GraphBase base = new GraphBase();

		base.setUp();

		try ( Transaction tx = graphDb.beginTx() ) {
			File zeta = new File ("target/x.txt");
			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(zeta), "UTF-8"));    
			DatabaseSubGraph sub = new DatabaseSubGraph(graphDb);
			SubGraphExporter sc = new SubGraphExporter(sub);
			
			sc.export(out);

			out.flush();
			out.close();

			tx.success();
		}

		base.shutdown();
	}

	public void setUp() throws IOException {
		FileUtils.deleteRecursively( new File( GRAPH_DB ) );
		graphDb = new GraphDatabaseFactory().newEmbeddedDatabase( GRAPH_DB );
		registerShutdownHook();
		createNodespace();
	}

	
	public void shutdown() {
		graphDb.shutdown();
	}

	
	public void createNodespace() {
		try (Transaction tx = graphDb.beginTx()) {

			Vector<Node> v = new Vector<Node>();

			// Create FIRST node
			v.add(graphDb.createNode());
			nodeID = v.get(counter).getId();

			v.add(graphDb.createNode());
			counter++;
			v.get(counter).setProperty( "desc", "MAN" );
			
			v.add(graphDb.createNode());
			counter++;
			v.get(counter).setProperty( "desc", "SOCRATES" );
			v.get(counter).createRelationshipTo(v.get(counter-1), RelTypes.IS);
			
			tx.success();
		}
	}


	private static Node getNeoNode()
	{
		return graphDb.getNodeById( nodeID )
				.getSingleRelationship( RelTypes.IS, Direction.OUTGOING )
				.getEndNode();
	}


	public static String printNeoFriends() {
		try ( Transaction tx = graphDb.beginTx() )
		{
			Node neoNode = getNeoNode();
			// START SNIPPET: friends-usage
			int numberOfFriends = 0;
			String output = neoNode.getProperty( "name" ) + "\n";
			Traverser friendsTraverser = getFriends( neoNode );
			for ( Path friendPath : friendsTraverser )
			{
				output += "At depth " + friendPath.length() + " => "
						+ friendPath.endNode()
						.getProperty( "name" ) + "\n";
				numberOfFriends++;
			}
			output += "Number of friends found: " + numberOfFriends + "\n";
			// END SNIPPET: friends-usage
			return output;
		}
	}

	public String toJsonD3Format() {
		String s = "[ {" + "\n";
		try ( Transaction tx = graphDb.beginTx() ) {

		}
		return s;
	}

	// START SNIPPET: get-friends
	private static Traverser getFriends(
			final Node person )
	{
		TraversalDescription td = graphDb.traversalDescription()
				.breadthFirst()
				.relationships( RelTypes.IS, Direction.OUTGOING )
				.evaluator( Evaluators.excludeStartPosition() );
		return td.traverse( person );
	}
	// END SNIPPET: get-friends

	public String printMatrixHackers()
	{
		try ( Transaction tx = graphDb.beginTx() )
		{
			// START SNIPPET: find--hackers-usage
			String output = "Hackers:\n";
			int numberOfHackers = 0;
			Traverser traverser = findHackers( getNeoNode() );
			for ( Path hackerPath : traverser )
			{
				output += "At depth " + hackerPath.length() + " => "
						+ hackerPath.endNode()
						.getProperty( "name" ) + "\n";
				numberOfHackers++;
			}
			output += "Number of hackers found: " + numberOfHackers + "\n";
			// END SNIPPET: find--hackers-usage
			return output;
		}
	}

	// START SNIPPET: find-hackers
	private Traverser findHackers( final Node startNode )
	{
		TraversalDescription td = graphDb.traversalDescription()
				.breadthFirst()
				.relationships( RelTypes.IS, Direction.OUTGOING )
				.relationships( RelTypes.IS, Direction.OUTGOING )
				.evaluator(
						Evaluators.includeWhereLastRelationshipTypeIs( RelTypes.IS ) );
		return td.traverse( startNode );
	}
	// END SNIPPET: find-hackers

	private void registerShutdownHook()
	{
		// Registers a shutdown hook for the Neo4j instance so that it
		// shuts down nicely when the VM exits (even if you "Ctrl-C" the
		// running example before it's completed)
		Runtime.getRuntime()
		.addShutdownHook( new Thread()
		{
			@Override
			public void run()
			{
				graphDb.shutdown();
			}
		} );
	}
}

