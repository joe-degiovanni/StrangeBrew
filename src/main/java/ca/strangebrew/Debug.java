/*
 * Created on Jun 15, 2005
 * by aavis
 *
 */
package ca.strangebrew;

import java.util.logging.Logger;

public class Debug {
	// private static final boolean DEBUG = true;
	public static boolean DEBUG = false;

	private static Logger logger = Logger.getLogger(Debug.class.getName());
	
	public static void set(boolean s){
		DEBUG = s;
		Debug.print("Debugging is on.");
	}
	
	
	public static void print(Object msg){
		if (DEBUG){
			logger.info(msg.toString());
		}
	}

}
