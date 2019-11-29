package simplification;

/**
 * For binary expressions, that is with only
 * two arguments and an operator.
 * @author jcroyer
 *
 */
public interface BinaryI {
	
	/**
	 * Get left expression.
	 *
	 * @return the left
	 */
	public Term getLeft();
	
	/**
	 * Get right expression.
	 *
	 * @return the right
	 */
	public Term getRight();
	
	/**
	 * Get the operator.
	 *
	 * @return the op
	 */
	public OperatorI getOp();

}
