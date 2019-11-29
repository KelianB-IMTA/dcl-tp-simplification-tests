package simplification;

/**
 * Interface for expressions.
 * @author jroyer
 *
 */
public interface Term {

	/**
	 * External representation.
	 *
	 * @return the string
	 */
	public  String toString();
	
	/**
	 * Compute the integer value of an expression.
	 * The expression is closed that is wihout variable.
	 * Use the call by value mechanism for binaries that is
	 * compute left and right then apply operator
	 *
	 * @return the int
	 */
	public  int compute();
	
	/**
	 * Test if zero.
	 *
	 * @return true, if is zero
	 */
	public  boolean isZero();
	
	/**
	 * Test if unit.
	 *
	 * @return true, if is unit
	 */
	public  boolean isUnit();
	
	/**
	 * Test if the expression is computable.
	 * That is without variable.
	 *
	 * @return true, if is computable
	 */
	public  boolean isComputable();
	
	/**
	 * Process one step of simplification.
	 * For instance 0 + X gives X; X + 0 gives X; 1 * X gives X; etc
	 *
	 * @return the term
	 */
	public Term oneReduction();
	
	/**
	 * Process the rules and get back the simplified expression.
	 * There is a really simple recursive definition for this.
	 * There is also a more boring one with a loop.
	 *
	 * @return the term
	 */
	public  Term engine();
	
}
