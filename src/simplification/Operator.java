package simplification;

/**
 * The Class Operator.
 *
 * @author jroyer
 */
public class Operator implements OperatorI {
	/**
	 *  + operator.
	 */
	public final static Operator PLUS = new Operator("+", 2);
	/**
	 * - operator.
	 */
	public final static Operator MOINS = new Operator("-", 2);
	/**
	 * / operator.
	 */
	public final static Operator DIV = new Operator("/", 2);
	 /**
	  * * operator.
	  */
	public final static Operator MULT = new Operator("*", 2);
	

	/** The arity. */
	protected int arity;
	
	/** The name. */
	protected String name;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Constructor.
	 *
	 * @param op the op
	 * @param ar the ar
	 */
	public Operator(String op, int ar){
		this.name=op;
		this.arity = ar;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.getName();
	}

	/* (non-Javadoc)
	 * @see simplification.OperatorI#getArity()
	 */
	public int getArity() {
		return this.arity;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.OperatorI#estPlus()
	 */
	public boolean estPlus() {
		return this.equals(PLUS);
	}

	/* (non-Javadoc)
	 * @see java.lang.OperatorI#estMoins()
	 */
	public boolean estMoins() {
		return this.equals(MOINS);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.OperatorI#estMult()
	 */
	public boolean estMult() {
		return this.equals(MULT);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.OperatorI#estDiv()
	 */
	public boolean estDiv() {
		return this.equals(DIV);
	}
}
