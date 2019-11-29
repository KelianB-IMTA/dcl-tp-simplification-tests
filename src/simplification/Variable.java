package simplification;

/**
 * representation des variables.
 */
public class Variable implements Term, VariableI {

    /**
     * the name.
     */
	protected String name;

	/**
	 * accesseur.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Instantiates a new variable.
	 *
	 * @param nom the nom
	 */
	public Variable(String nom) throws InvalidVariableNameException {
		if(nom == null) {
			throw new NullPointerException("Cannot create a variable with a null name");
		}
		if(nom.length() == 0) {
			throw new InvalidVariableNameException("Cannot create a variable with a empty name");
		}
				try {
			Double.parseDouble(nom);
			throw new InvalidVariableNameException("A variable name cannot be a number");
		}
		catch(NumberFormatException e) {
			// If this exception is fired, we now the name isn't a number
		}
		
		this.name = nom;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.getName();
	}

	/**
	 * @see simplification.Term#compute()
	 */
	public int compute() {		
		System.out.println("Variable.calculer: actuellement je ne sais pas faire");
		return 0;
	}

	/**
	 * @see simplification.Term#isZero()
	 */
	public boolean isZero() {
		return false;
	}
	
	/**
	 * @see simplification.Term#isUnit()
	 */
	//
	public boolean isUnit() {
		return false;
	}

	/**
	 * @see simplification.Term#engine()
	 */
	public Term engine() {
		return this;
	}

	/**
	 * @see simplification.Term#isComputable()
	 */
	public boolean isComputable() {
		return false;
	}


	/**
	 * @see simplification.Term#oneReduction()
	 */
	public Term oneReduction() {
		return this;
	}


}
