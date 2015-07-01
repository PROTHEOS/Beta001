/*
 * BasicObjectMBean.java - MBean interface describing the management operations and
 * attributes for the BasicObject World MBean. In this case there are two operations,
 * "sayHello" and "add", and two attributes, "Name" and "CacheSize".
 */

package net.protheos.core;

public interface BasicObjectMBean {
  
    // a read-only attribute called Name of type String
    public int getID();
    public String getDescription();
    
   // public int add(int x, int y);
    
    // a read-write attribute called CacheSize of type int
    public int getCacheSize();
    public void setCacheSize(int size);
}
