/*
 * BasicObject.java - MBean implementation for the BasicObject MBean. This class must
 * implement all the Java methods declared in the BasicObjectMBean interface,
 * with the appropriate behavior for each one.
 */

package net.protheos.core;

import javax.management.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.management.ManagementFactory;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Set;
import java.util.logging.*;
import java.util.Calendar;

/**
 * Date: 24/01/2015
 * Time: 19:20:49
 * Developer: Marcelo
 * Objective: To create a basicObject structure that will serve to all objects in PRO.T.H.E.O.S.
 * TODO: Implement dynamic MBean
 * Tags: MBean, Serializable
 */

public class BasicObject extends NotificationBroadcasterSupport implements BasicObjectMBean, Serializable, Cloneable {

	
	private boolean logState = true;
	private static int ID = (int) (System.currentTimeMillis() & 0xfffffff);
	private static final long serialVersionUID = ID;
	private String description = this.getClass().toString().substring(this.getClass().toString().lastIndexOf(".") + 1);
	private String lifeCycle = "";
	private Date creationDate = Calendar.getInstance().getTime();
	private static final Logger logger = Logger.getLogger(BasicObject.class.getName());
	private static final int DEFAULT_CACHE_SIZE = 200;
	private int cacheSize = DEFAULT_CACHE_SIZE;
	private long sequenceNumber = 1;
    private String objectNameBean = this.getClass().getPackage().toString().replace("package ", "") + ":type=" + description;

	
	
	/**
	 * Date: 16/06/2015
	 * Time: 10:58:11
	 * Developer: Marcelo Gagliano
	 * Objective: Create the instance of BasicObject in memory.
	 * Receive: Null
	 * Return: @return a basic object instance.
	 * TODO: None
	 */
	public BasicObject() {
		// TODO Auto-generated constructor stub
		
		lifeCycle = "Object " + this.getDescription() + " (#" + this.getID() + ") created on " + creationDate.toString() + ".\n";
		logger.info(lifeCycle);
		
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        // Construct the ObjectName for the Hello MBean we will register
		try {
			ObjectName mbeanName = new ObjectName(objectNameBean);
			 server.registerMBean(this, mbeanName);
			 Set<ObjectInstance> instances = server.queryMBeans(new ObjectName(objectNameBean), null);
			 ObjectInstance instance = (ObjectInstance) instances.toArray()[0];
		} catch (MalformedObjectNameException e) {
			// TODO Auto-generated catch block
			logger.severe("Object " + this.getDescription() + " (#" + this.getID() + ") suffered an "+ e.getClass().toString().substring(this.getClass().toString().lastIndexOf(".") + 1) + ", because " + e.getCause().toString() + ".");
			this.appendLifeCycle("Object " + this.getDescription() + " (#" + this.getID() + ") suffered an "+ e.getClass().toString().substring(this.getClass().toString().lastIndexOf(".") + 1) + ", because " + e.getCause().toString() + ".");
			e.printStackTrace();
		
		} catch (JMException e) {
			// TODO Auto-generated catch block
			//System.out.println("Description = " + this.getDescription());
			//System.out.println("ID = " + this.getID());
			System.out.println("Exception = " + e.getClass().toString());
			System.out.println("Cause = " + e.getCause().toString());
						
			logger.severe("Object " + this.getDescription() + " (#" + this.getID() + ") suffered an "+ e.getClass().toString().substring(this.getClass().toString().lastIndexOf(".") + 1) + ", because " + e.getCause().toString() + ".");
			this.appendLifeCycle("Object " + this.getDescription() + " (#" + this.getID() + ") suffered an "+ e.getClass().toString().substring(this.getClass().toString().lastIndexOf(".") + 1) + ", because " + e.getCause().toString() + ".");
			e.printStackTrace();

	} catch (Exception e) {
		// TODO Auto-generated catch block
		//System.out.println("Description = " + this.getDescription());
		//System.out.println("ID = " + this.getID());
		System.out.println("Exception = " + e.getClass().toString());
		System.out.println("Cause = " + e.getCause().toString());
					
		logger.severe("Object " + this.getDescription() + " (#" + this.getID() + ") suffered an "+ e.getClass().toString().substring(this.getClass().toString().lastIndexOf(".") + 1) + ", because " + e.getCause().toString() + ".");
		this.appendLifeCycle("Object " + this.getDescription() + " (#" + this.getID() + ") suffered an "+ e.getClass().toString().substring(this.getClass().toString().lastIndexOf(".") + 1) + ", because " + e.getCause().toString() + ".");
		e.printStackTrace();
	}
	}

	
	/**
	 * Date: 16/06/2015
	 * Time: 10:58:11
	 * Developer: Marcelo Gagliano
	 * Objective: Create the instance of BasicObject in memory.
	 * Receive: @param a string with the object description.
	 * Return: @return a basic object instance.
	 * TODO: None
	 */
	public BasicObject(String desc) {
		// TODO Auto-generated constructor stub
		
		this.description = desc;
		lifeCycle = "Object " + this.getDescription() + " (#" + this.getID() + ") created on " + creationDate.toString() + ".\n";
		logger.info(lifeCycle);

		
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        // Construct the ObjectName for the Hello MBean we will register
		try {
			ObjectName mbeanName = new ObjectName(objectNameBean);
			 server.registerMBean(this, mbeanName);
			 Set<ObjectInstance> instances = server.queryMBeans(new ObjectName(objectNameBean), null);
			 ObjectInstance instance = (ObjectInstance) instances.toArray()[0];
		} catch (MalformedObjectNameException e) {
			// TODO Auto-generated catch block
			logger.severe("Object " + this.getDescription() + " (#" + this.getID() + ") suffered an "+ e.getClass().toString().substring(this.getClass().toString().lastIndexOf(".") + 1) + ", because " + e.getCause().toString() + ".");
			this.appendLifeCycle("Object " + this.getDescription() + " (#" + this.getID() + ") suffered an "+ e.getClass().toString().substring(this.getClass().toString().lastIndexOf(".") + 1) + ", because " + e.getCause().toString() + ".");
			e.printStackTrace();
		
		} catch (JMException e) {
			// TODO Auto-generated catch block
			logger.severe("Object " + this.getDescription() + " (#" + this.getID() + ") suffered an "+ e.getClass().toString().substring(this.getClass().toString().lastIndexOf(".") + 1) + ", because " + e.getCause().toString() + ".");
			this.appendLifeCycle("Object " + this.getDescription() + " (#" + this.getID() + ") suffered an "+ e.getClass().toString().substring(this.getClass().toString().lastIndexOf(".") + 1) + ", because " + e.getCause().toString() + ".");
			e.printStackTrace();
		}
	}

	
	/**
	 * Date: 16/06/2015
	 * Time: 10:58:11
	 * Developer: Marcelo Gagliano
	 * Objective: Create the instance of BasicObject in memory, using a serializable object.
	 * Receive: @param a file input stream with the object description.
	 * Return: @return a basic object instance.
	 * TODO: FIX IT 
	 */
	public BasicObject copyObject(FileInputStream file) {
			
		BasicObject retObj = null;
		
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		try {
			retObj =(BasicObject) ois.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		try {
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retObj;
	}
	
	
	/**
	 * Date: 16/06/2015
	 * Time: 11:58:11
	 * Developer: Marcelo Gagliano
	 * Objective: Finalize the object and clean the memory heap.
	 * Receive: @param Null
	 * Return: @return NULL
	 * TODO: None
	 */
	public void finalize(){
		//this.setLogState(null);
		logger.info("Object " + this.getDescription() + " (#" + this.getID() + ") finalized on " + Calendar.getInstance().getTime() + ".");
		this.appendLifeCycle("Object " + this.getDescription() + " (#" + this.getID() + ") finalized on " + Calendar.getInstance().getTime() + ".");
		this.outputObject();
		this.outputLifeCycle();
		System.runFinalization();
		System.gc();
	}


	/**
	 * Date: 19/06/2015
	 * Time: 13:18:11
	 * Developer: Marcelo Gagliano / Ronaldo Lanhellas
	 * Objective: To output in a file the serializable object.
	 * Receive: @param Null
	 * Return: @return a file containing the serializable object.
	 * TODO: None
	 * LINK: @link http://www.devmedia.com.br/use-a-serializacao-em-java-com-seguranca/29012#ixzz3dWm8RrIw
	 */
	public void outputObject() {
	
		try {
			FileOutputStream fout = new FileOutputStream("./obj/" + this.getFileName() + ".ser");
			ObjectOutputStream oos = null;
			try {
				oos = new ObjectOutputStream(fout);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.severe("Object " + this.getDescription() + " (#" + this.getID() + ") suffered an "+ e.getClass().toString().substring(this.getClass().toString().lastIndexOf(".") + 1) + ", because " + e.getCause().toString() + ".");
				this.appendLifeCycle("Object " + this.getDescription() + " (#" + this.getID() + ") suffered an "+ e.getClass().toString().substring(this.getClass().toString().lastIndexOf(".") + 1) + ", because " + e.getCause().toString() + ".");
				e.printStackTrace();
			}
			try {
				oos.writeObject(this);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.severe("Object " + this.getDescription() + " (#" + this.getID() + ") suffered an "+ e.getClass().toString().substring(this.getClass().toString().lastIndexOf(".") + 1) + ", because " + e.getCause().toString() + ".");
				this.appendLifeCycle("Object " + this.getDescription() + " (#" + this.getID() + ") suffered an "+ e.getClass().toString().substring(this.getClass().toString().lastIndexOf(".") + 1) + ", because " + e.getCause().toString() + ".");
				e.printStackTrace();
			}
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.severe("Object " + this.getDescription() + " (#" + this.getID() + ") suffered an "+ e.getClass().toString().substring(this.getClass().toString().lastIndexOf(".") + 1) + ", because " + e.getCause().toString() + ".");
				this.appendLifeCycle("Object " + this.getDescription() + " (#" + this.getID() + ") suffered an "+ e.getClass().toString().substring(this.getClass().toString().lastIndexOf(".") + 1) + ", because " + e.getCause().toString() + ".");
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.severe("Object " + this.getDescription() + " (#" + this.getID() + ") suffered an "+ e.getClass().toString().substring(this.getClass().toString().lastIndexOf(".") + 1) + ", because " + e.getCause().toString() + ".");
			this.appendLifeCycle("Object " + this.getDescription() + " (#" + this.getID() + ") suffered an "+ e.getClass().toString().substring(this.getClass().toString().lastIndexOf(".") + 1) + ", because " + e.getCause().toString() + ".");
			e.printStackTrace();
		}
	}
	

	/**
	 * Date: 19/06/2015
	 * Time: 23:18:11
	 * Developer: Marcelo Gagliano / Adam Bien
	 * Objective: To output in a file the object's life cycle.
	 * Receive: @param Null
	 * Return: @return a file containing the object's life cycle.
	 * TODO: None 
	 * LINK: @link http://www.adam-bien.com/roller/abien/entry/java_7_writing_a_string
	 */
	public void outputLifeCycle() {

		try {
			Files.write(Paths.get("./lifecycle/" + this.getFileName() + ".olc"), this.getLifeCycle().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.severe("Object " + this.getDescription() + " (#" + this.getID() + ") suffered an "+ e.getClass().toString().substring(this.getClass().toString().lastIndexOf(".") + 1) + ", because " + e.getCause().toString() + ".");
			this.appendLifeCycle("Object " + this.getDescription() + " (#" + this.getID() + ") suffered an "+ e.getClass().toString().substring(this.getClass().toString().lastIndexOf(".") + 1) + ", because " + e.getCause().toString() + ".");
			e.printStackTrace();
		}
	}

	

	/**
	 * Date: 19/06/2015
	 * Time: 23:12:11
	 * Developer: Marcelo Gagliano
	 * Objective: Auxiliary method to generate a standard file name.
	 * Receive: @param Null
	 * Return: @return a file containing the object's life cycle.
	 * TODO: None 
	 */
	private String getFileName(){
		Calendar cal = Calendar.getInstance();
	    cal.setTime(this.creationDate);
	    String year = new Integer(cal.get(Calendar.YEAR)).toString();
	    
	    String month = new Integer(1 + cal.get(Calendar.MONTH)).toString();
	    if (month.length() <= 1) month = "0" + month; 
	    
	    String day = new Integer(cal.get(Calendar.DAY_OF_MONTH)).toString();
	    if (day.length() <= 1) day = "0" + day; 
	
	    String hour = new Integer(cal.get(Calendar.HOUR_OF_DAY)).toString();
	    if (hour.length() <= 1) hour = "0" + hour; 
	
	    String minute = new Integer(cal.get(Calendar.MINUTE)).toString();
	    if (minute.length() <= 1) minute = "0" + minute; 
	    
	    String second = new Integer(cal.get(Calendar.SECOND)).toString();
	    if (second.length() <= 1) second = "0" + second; 
	    
		return(year + "-" + month + "-" + day + "-" + hour + "h" + minute + "m" + second + "s-" + this.getDescription() + "-" + this.getID());
	
	}
	
	/**
	 * Date: 19/06/2015
	 * Time: 13:18:11
	 * Developer: Marcelo Gagliano
	 * Objective: To get the object's life cycle log.
	 * Receive: @param Null
	 * Return: @return a string containing object's life cycle.
	 * TODO: None
	 */
	public String getLifeCycle() {
		return lifeCycle;
	}

	
	/**
	 * Date: 19/06/2015
	 * Time: 13:18:11
	 * Developer: Marcelo Gagliano
	 * Objective: To append the object life cycle log.
	 * Receive: @param a string containing the append to the object's life cycle.
	 * Return: @return null
	 * TODO: None
	 */
	public void appendLifeCycle(String lifeCycle) {
		this.lifeCycle = this.lifeCycle + lifeCycle + "\n";
	}

	
	/**
	 * Date: 19/06/2015
	 * Time: 13:18:11
	 * Developer: Marcelo Gagliano
	 * Objective: To get the object's creation date.
	 * Receive: @param Null
	 * Return: @return a Date object containing the object's creation date.
	 * TODO: None
	 */
	public Date getCreationDate() {
		return creationDate;
	}


	/**
	 * Date: 19/06/2015
	 * Time: 13:18:11
	 * Developer: Marcelo Gagliano
	 * Objective: To get the object's default cache size.
	 * Receive: @param Null
	 * Return: @return an integer containing the object's default cache size.
	 * TODO: None
	 */
	public int getDefaultCacheSize() {
		return DEFAULT_CACHE_SIZE;
	}

	
	/**
	 * Date: 19/06/2015
	 * Time: 13:18:11
	 * Developer: Marcelo Gagliano
	 * Objective: To get the object bean's name.
	 * Receive: @param Null
	 * Return: @return a String containing object bean's name.
	 * TODO: None
	 */
	public String getObjectNameBean() {
		return objectNameBean;
	}
	

	/**
	 * Date: 05/04/2015
	 * Time: 11:22:11
	 * Developer: Marcelo Gagliano
	 * Objective: To return a String that represents the object
	 * Receive: @param Null
	 * Return: @return a String that represents the object
	 * TODO: None
	 */

	@Override
	public String toString() {
		return this.getDescription();
	}

	
	/**
	 * Date: 05/04/2015
	 * Time: 11:22:11
	 * Developer: Marcelo Gagliano
	 * Objective: To return the Log State Parameter: is it ON (True) or OFF (False)?
	 * Receive: @param Null
	 * Return: @return the logState
	 * TODO: None
	 */
	public boolean isLogState() {
		return logState;
	}


	/**
	 * Date: 05/04/2015
	 * Time: 11:22:11
	 * Developer: Marcelo Gagliano
	 * Objective: To turn the Log State Parameter ON (True) or OFF (False).
	 * Receive: @param the logState to set: True (ON) or False (OFF).
	 * Return: @return NULL
	 * TODO: None
	 */
	public void setLogState(boolean logState) {
		this.logState = logState;
	}


	/**
	 * Date: 05/04/2015
	 * Time: 11:22:52
	 * Developer: Marcelo Gagliano
	 * Objective: Return the logger object.
	 * Receive: Null
	 * Return: @return the logger object.
	 * TODO: None
	 */
	public static Logger getLogger() {
		return logger;
	}


	/**
	 * Date: 16/06/2015
	 * Time: 11:23:52
	 * Developer: Marcelo Gagliano / Java Documentation.
	 * Objective: Getter for the ID attribute. "The pattern shown here is frequent: the
       getter returns a private field representing the attribute value. In our
       case, the attribute value never changes, but for other attributes it
       might change as the application runs. Consider an attribute representing
       statistics such as uptime or memory usage, for example. Being read-only
       just means that it can't be changed through the management interface."
	 * Receive: Null
	 * Return: @return the object ID.
	 * TODO: Update the description taken from here{@link https://docs.oracle.com/javase/tutorial/jmx/mbeans/standard.html}.
	 */
	public int getID() {
		return this.ID;
	}

	
	/**
	 * Date: 16/06/2015
	 * Time: 11:23:52
	 * Developer: Java Documentation
	 * Objective: "Getter for the CacheSize attribute. The pattern shown here is
       frequent: the getter returns a private field representing the
       attribute value, and the setter changes that field."
	 * Receive: Null
	 * Return: @return the cache size.
	 * TODO: Update the description taken from here{@link https://docs.oracle.com/javase/tutorial/jmx/mbeans/standard.html}.
	 */
	public int getCacheSize() {
		return this.cacheSize;
	}

	
	/**
	 * Date: 16/06/2015
	 * Time: 11:23:52
	 * Developer: Java Documentation
	 * Objective: "Setter for the CacheSize attribute. To avoid problems with
     * stale values in multithreaded situations, it is a good idea
     * for setters to be synchronized."
	 * Receive: @param the cache size.
	 * Return: @return NULL.
	 * TODO: Update the description taken from here{@link https://docs.oracle.com/javase/tutorial/jmx/mbeans/standard.html}.
	 */
	public synchronized void setCacheSize(int size) {
		int oldSize = this.cacheSize;
		this.cacheSize = size;

		/* In a real application, changing the attribute would
	   typically have effects beyond just modifying the cacheSize
	   field.  For example, resizing the cache might mean
	   discarding entries or allocating new ones. The logic for
	   these effects would be here. */
		System.out.println("Cache size updated for " + this.getDescription() + " ID" +  this.getID() + ": " + this.cacheSize);

		/* Construct a notification that describes the change. The
	   "source" of a notification is the ObjectName of the MBean
	   that emitted it. But an MBean can put a reference to
	   itself ("this") in the source, and the MBean server will
	   replace this with the ObjectName before sending the
	   notification on to its clients.

	   For good measure, we maintain a sequence number for each
	   notification emitted by this MBean.

	   The oldValue and newValue parameters to the constructor are
	   of type Object, so we are relying on Tiger's autoboxing
	   here.  */
		Notification n =
				new AttributeChangeNotification(this,
						sequenceNumber++,
						System.currentTimeMillis(),
						"CacheSize changed",
						"CacheSize",
						"int",
						oldSize,
						this.cacheSize);

		/* Now send the notification using the sendNotification method
	   inherited from the parent class NotificationBroadcasterSupport. */
		sendNotification(n);
	}

	
	/**
	 * Date: 16/06/2015
	 * Time: 11:23:52
	 * Developer: Java Documentation
	 * Objective: To get the notification in case the monitored object (MBean) changes any attribute.
	 * Receive: @param NULL.
	 * Return: @return The Notification info..
	 * TODO: None.
	 */
	@Override
	public MBeanNotificationInfo[] getNotificationInfo() {
		String[] types = new String[] {
				AttributeChangeNotification.ATTRIBUTE_CHANGE
		};
		String name = AttributeChangeNotification.class.getName();
		String description = "An attribute of this MBean has changed";
		MBeanNotificationInfo info =
				new MBeanNotificationInfo(types, name, description);
		return new MBeanNotificationInfo[] {info};
	}


	/**
	 * Date: 16/06/2015
	 * Time: 18:11:11
	 * Developer: Marcelo Gagliano
	 * Objective: To get the Description of an object.
	 * Receive: @param NULL.
	 * Return: @return the new description.
	 * TODO: None
	 */	
	public String getDescription() {
		return description;
	}

	
	/**
	 * Date: 24/01/2015
	 * Time: 19:20:49
	 * Developer: Marcelo Gagliano
	 * Objective: To create a routine with the purpose of testing the object.
	 * Receive: @param args
	 * Return: void
	 * TODO: TODO
	 * Tags: @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BasicObject x = new BasicObject();
		
		try {
			x.outputObject();
			x.outputLifeCycle();
			Thread.sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			logger.severe("Object " + logger.getName() + " (#" + x.getID() + ") suffered an "+ e.getClass().toString().substring(x.getClass().toString().lastIndexOf(".") + 1) + ", because " + e.getCause().toString() + ".");
			x.appendLifeCycle("Object " + logger.getName() + " (#" + x.getID() + ") suffered an "+ e.getClass().toString().substring(x.getClass().toString().lastIndexOf(".") + 1) + ", because " + e.getCause().toString() + ".");
			e.printStackTrace();
		}
		x.finalize();
	}

	
}
