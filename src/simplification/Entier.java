package simplification;

/**
 * Wrapping class for integers.
 * Subclassing Integer is another solution
 */
public class Entier implements Term, EntierI {
	
	/**
	 * Constant 0.
	 */
	public final static Entier ZERO = new Entier(0);
	
	/**
	 * Constant 1.
	 */
	public final static Entier UN = new Entier(1);
	

	/** The valeur. */
	protected int valeur;
	
	/**
	 * Gets the value.
	 *
	 * @return the valeur
	 */
	public int getValue() {
		return valeur;
	}
	
	/**
	 * Constructor.
	 *
	 * @param a the a
	 */
	public Entier(int a){
		this.valeur = a;
	}

	/** 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return String.valueOf(this.valeur);
	}


	/**
	 * @see simplification.Term#compute()
	 */
	public int compute() {
		return this.valeur;
	}

	/**
	 * @see simplification.Term#isZero()
	 */
	public boolean isZero() {
		return this.valeur==0;
	}


	/**
	 * @see simplification.Term#isUnit()
	 */
	public boolean isUnit() {
		return this.valeur==1;
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
		return true;
	}

	/**
	 * @see simplification.Term#oneReduction()
	 */
	public Term oneReduction() {
		return this;
	}
	
	
	@Override
	public boolean equals(Object o) {
		return o != null && o instanceof Entier && ((Entier) o).getValue() == getValue();
	}
	
}
