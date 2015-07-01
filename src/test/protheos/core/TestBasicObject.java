/**
 * 
 */
package test.protheos.core;

import static org.junit.Assert.*;
import net.protheos.core.BasicObject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author marce_000
 *
 */
public class TestBasicObject {
	static BasicObject x = null;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		x = new BasicObject();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link net.protheos.core.BasicObject#copyObject(java.io.FileInputStream)}.
	 */
	@Test
	public final void testCopyObject() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.protheos.core.BasicObject#getDefaultCacheSize()}.
	 */
	@Test
	public final void testGetDefaultCacheSize() {
		//fail("Not yet implemented"); // TODO
		assertEquals(x.getDefaultCacheSize(), 200);
	}

	/**
	 * Test method for {@link net.protheos.core.BasicObject#isLogState()}.
	 */
	@Test
	public final void testIsLogState() {
		//fail("Not yet implemented"); // TODO
		assertTrue(x.isLogState());
	}

	/**
	 * Test method for {@link net.protheos.core.BasicObject#getCacheSize()}.
	 */
	@Test
	public final void testGetCacheSize() {
		//fail("Not yet implemented"); // TODO
		assertEquals(x.getCacheSize(), 200);
	}

	/**
	 * Test method for {@link net.protheos.core.BasicObject#getDescription()}.
	 */
	@Test
	public final void testGetDescription() {
		//fail("Not yet implemented"); // TODO
		assertEquals(x.getDescription(), "BasicObject");
	}

}
