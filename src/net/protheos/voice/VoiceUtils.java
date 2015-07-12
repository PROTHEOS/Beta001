/**
 * Project: Beta001
 * Package: net.protheos.voice
 * Filename: Utils.java
 * Date: 12 de jul de 2015
 * Time: 16:03:01
 * Developer: marce_000
 */
package net.protheos.voice;

/// A collection of utility functions used in 
/// Voce.
public class VoiceUtils
{
	private static boolean mPrintDebug = false;

	/// A simple message logging function.  The message type gets printed 
	/// before the actual message.
	static public void log(String msgType, String msg)
	{
		// If we're ignoring debug messages and this one is a debug 
		// message, return.
		if (!mPrintDebug && msgType.equals("debug"))
		{
			return;
		}

		String finalMessage = "[Voce";

		if (!msgType.equals(""))
		{
			finalMessage = finalMessage + " " + msgType;
		}

		finalMessage = finalMessage + "] " + msg;
		System.out.println(finalMessage);
		System.out.flush();
	}
	
	/// Sets how much debug output to print ('true' prints debug and error 
	/// messages; 'false' prints only error messages).
	static public void setPrintDebug(boolean printDebug)
	{
		mPrintDebug = printDebug;
	}
}
