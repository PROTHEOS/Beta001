/**
 * Project: Beta001
 * Package: test.protheos.neural.matrix.exception
 * Filename: TestMatrixException.java
 * Date: 1 de jul de 2015
 * Time: 13:17:27
 * Developer: marce_000
 */
package test.protheos.neural.matrix.exception;

import junit.framework.TestCase;
import net.protheos.neural.matrix.exception.MatrixError;


public class TestMatrixException extends TestCase {
	public void testMatrixError()
	{
		NullPointerException npe = new NullPointerException();
		new MatrixError(npe);
		//new NeuralNetworkError(npe);
	}
}
