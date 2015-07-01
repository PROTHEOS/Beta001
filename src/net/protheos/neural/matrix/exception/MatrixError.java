/**
 * Project: Beta001
 * Package: 
 * Filename: MatrixError.java
 * Date: 1 de jul de 2015
 * Time: 13:12:47
 * Developer: marce_000
 */

/**
 * Introduction to Neural Networks with Java, 2nd Edition
 * Copyright 2008 by Heaton Research, Inc. 
 * http://www.heatonresearch.com/books/java-neural-2/
 * 
 * ISBN13: 978-1-60439-008-7  	 
 * ISBN:   1-60439-008-5
 *   
 * This class is released under the:
 * GNU Lesser General Public License (LGPL)
 * http://www.gnu.org/copyleft/lesser.html
 */
package net.protheos.neural.matrix.exception;

/**
 * MatrixError: Used by the matrix classes to indicate an error.
 * 
 * @author Jeff Heaton
 * @version 2.1
 */
public class MatrixError extends RuntimeException {

	/**
	 * Serial id for this class.
	 */
	private static final long serialVersionUID = -8961386981267748942L;

	/**
	 * Construct this exception with a message.
	 * @param t The other exception.
	 */
	public MatrixError(final String message) {
		super(message);
	}

	/**
	 * Construct this exception with another exception.
	 * @param t The other exception.
	 */
	public MatrixError(final Throwable t) {
		super(t);
	}

}
