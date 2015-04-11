
/**
 * Project: Beta001
 * Package: net.protheos.core
 * Filename: BasicObject.java
 * Date: 24/01/2015
 * Time: 19:20:49
 * Developer: Marcelo Gagliano
 */
package net.protheos.core;
import java.util.logging.*;

/**
 * @author Marcelo
 *
 */
public class BasicObject {

	/**
	 * Date: 24/01/2015
	 * Time: 19:20:49
	 * Developer: Marcelo
	 * Objective: <>
	 * Receive: BasicObject
	 * Return: net.protheos.core.BasicObject.java
	 * TODO: TODO
	 * Tags:
	 */

	boolean logState = true;
	private static final Logger logger = Logger.getLogger(BasicObject.class.getName());


	public BasicObject() {
		// TODO Auto-generated constructor stub
		logger.info("Logger Name: "+logger.getName());

	}
public void finalize(){
	//this.setLogState(null);

	System.gc();
}




	/**
	 * Date: 05/04/2015
	 * Time: 11:22:11
	 * Developer: Marcelo
	 * Objective: <>
	 * Receive: Null
	 * Return: @return the logState
	 * TODO: TODO
	 */
	public boolean isLogState() {
		return logState;
	}




	/**
	/**
	 * Date: 05/04/2015
	 * Time: 11:22:11
	 * Developer: Marcelo
	 * Objective: <>
	 * Receive: @param logState the logState to set
	 * Return: @return the logState
	 * TODO: TODO
	 */
	public void setLogState(boolean logState) {
		this.logState = logState;
	}




	/**
	 * Date: 05/04/2015
	 * Time: 11:22:52
	 * Developer: Marcelo
	 * Objective: <>
	 * Receive: Null
	 * Return: @return the logger
	 * TODO: TODO
	 */
	public static Logger getLogger() {
		return logger;
	}




	/**
	 * Date: 24/01/2015
	 * Time: 19:20:49
	 * Developer: Marcelo
	 * Objective: <>
	 * Receive: BasicObject
	 * Return: void
	 * TODO: TODO
	 * Tags: @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
