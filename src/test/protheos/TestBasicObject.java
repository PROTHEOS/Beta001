package test.protheos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;
import net.protheos.core.BasicObject;

public class TestBasicObject extends TestCase{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBasicObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsLogState() {
		assertFalse((new BasicObject()).isLogState());
	}

	@Test
	public void testGetLogger() {
		fail("Not yet implemented");
	}

}
