package simplification;

/**
 * Interface for operators with arity >= 0.
 * That means that constant (operator with arity 0)
 * are subclasses of Terms.
 * @author jcroyer
 *
 */
public interface OperatorI {
	
	/**
	 * return the name of the operator.
	 * @return a string
	 */
	public String getName();
	
	/**
	 * Give the arity of the oprator.
	 * That is it number of arguments GE 1
	 * @return an int
	 */
	public int getArity();
	
	/**
	 * Give the external representation.
	 *
	 * @return the string
	 */
	public String toString();

	/**
	 * Verifies whether this operator is a Plus or not
	 *
	 * @return true if the operator is a Plus, else false
	 */	
	public boolean estPlus();
	

	/**
	 * Verifies whether this operator is a Minus or not
	 *
	 * @return true if the operator is a Minus, else false
	 */	
	public boolean estMoins();


	/**
	 * Verifies whether this operator is a Mult or not
	 *
	 * @return true if the operator is a Mult, else false
	 */	
	public boolean estMult();
	

	/**
	 * Verifies whether this operator is a Div or not
	 *
	 * @return true if the operator is a Div, else false
	 */	
	public boolean estDiv();
}
