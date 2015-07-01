/**
 * Project: Beta001
 * Package: test.protheos.brain.nlp
 * Filename: TestSentence.java
 * Date: 30/05/2015
 * Time: 08:30:19
 * Developer: "Marcelo Gagliano"
 */
package test.protheos.nlp;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.protheos.nlp.Sentence;

/**
 * @author "Marcelo Gagliano"
 *
 */
public class TestSentence {

	/**
	 * Date: 30/05/2015
	 * Time: 08:30:19
	 * Developer: "Marcelo Gagliano"
	 * Objective: <>
	 * Receive: TestSentence
	 * Return: void
	 * TODO: TODO
	 * Tags: @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Date: 30/05/2015
	 * Time: 08:30:19
	 * Developer: "Marcelo Gagliano"
	 * Objective: <>
	 * Receive: TestSentence
	 * Return: void
	 * TODO: TODO
	 * Tags: @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Date: 30/05/2015
	 * Time: 08:30:19
	 * Developer: "Marcelo Gagliano"
	 * Objective: <>
	 * Receive: TestSentence
	 * Return: void
	 * TODO: TODO
	 * Tags: @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Date: 30/05/2015
	 * Time: 08:30:19
	 * Developer: "Marcelo Gagliano"
	 * Objective: <>
	 * Receive: TestSentence
	 * Return: void
	 * TODO: TODO
	 * Tags: @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Sentence s = new Sentence();

		s.tokenize("SOCRATES IS MAN");
		assertEquals("SOCRATES", s.getSubject());
		assertEquals("IS", s.getVerb());
		assertEquals("MAN", s.getObject());

		s.tokenize("IS SOCRATES MORTAL");
		assertEquals("SOCRATES", s.getSubject());
		assertEquals("IS", s.getVerb());
		assertEquals("MORTAL", s.getObject());

		s.tokenize("MAN ARE MORTAL");
		assertEquals("MAN", s.getSubject());
		assertEquals("ARE", s.getVerb());
		assertEquals("MORTAL", s.getObject());

		s.tokenize("ARE MAN MORTAL");
		assertEquals("MAN", s.getSubject());
		assertEquals("ARE", s.getVerb());
		assertEquals("MORTAL", s.getObject());


	}

}
