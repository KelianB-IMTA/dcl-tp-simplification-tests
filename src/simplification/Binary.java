package simplification;

/**
 * la classe des expressions binaires.
 *
 * @author jroyer
 */
public class Binary implements Term, BinaryI {
	
	/** The right. */
	protected Term left, right;

	/** The op. */
	protected Operator op;

	/**
	 * Instantiates a new binary.
	 *
	 * @param terme1 the terme 1
	 * @param op1 the op 1
	 * @param terme2 the terme 2
	 */
	public Binary(Term terme1, Operator op1, Term terme2) {
		this.left = terme1;
		this.right = terme2;
		this.op = op1;
	}

	/**
	 * Gets the left.
	 *
	 * @return the left
	 */
	public Term getLeft() {
		return left;
	}

	/** 
	 * @see simplification.BinaryI#getRight()
	 */
	public Term getRight() {
		return this.right;
	}

	/**
	 * Gets the op.
	 *
	 * @return the op
	 */
	public Operator getOp() {
		return op;
	}

	/**
	 * impression.
	 *
	 * @return the string
	 */
	public String toString() {
		return "(" + left.toString() + " " + op.getName() + " "
				+ right.toString() + ")";
	}

	// ========= calcul d'une expression
	/**
	 * expression est-elle calculable.
	 *
	 * @return true, if is computable
	 */
	public boolean isComputable() {
		return this.left.isComputable() && this.right.isComputable();
	}

	/**
	 * Compute expression
	 * in a value passing mode.
	 *
	 * @return the int
	 */
	public int compute() {
		int a = this.getLeft().compute();
		int b = this.getRight().compute();
		OperatorI op = this.getOp();
		int c = 0;
		if (op == Operator.PLUS) {
			c = a + b;
		} else if (op == Operator.MULT) {
			c = a * b;
		} else if (op == Operator.MOINS) {
			c = a - b;
		} else 	if (op == Operator.DIV) {
			c = a / b;
		} else {
			// add exception ? 
		}
		return c;
	}


	/** 
	 * @see simplification.Term#isZero()
	 * un binaire ne peut etre egale a zero sinon c un entier
	 */
	public boolean isZero() {
		return false;
	}

	/** 
	 * @see simplification.Term#isUnit()
	 * un binaire n'est pas un entier
	 */
	/*
	 * 
	 */
	public boolean isUnit() {
		return false;
	}

	// ============== reduction des simplifications
	/**
	 * One simplification important
	 *
	 * @return the term
	 */
	public Term oneReduction() {
		// -------- cas calculable
		if (this.isComputable()) {
			return new Entier(this.compute());
		} else {
			Term gauche = this.left;
			Term droit = this.right;
			Operator op = this.op;
			// -------------addition
			if (op == Operator.PLUS) {
				if (gauche.isZero()) {
					return droit;
				} else if (droit.isZero()) {
					return gauche;
				} else {
					return this;
				}
				// ------- cas soustraction
			} else if (op == Operator.MOINS) {
				if (droit.isZero()) {
					return gauche;
					// cas inverse besoin du -
				} else {
					return this;
				}
				// ------- cas multiplication
			} else if (op == Operator.MULT) {
				if (droit.isUnit()) {
					return gauche;
				} else if (droit.isZero()) {
					return Entier.ZERO;
				} else if (gauche.isUnit()) {
					return droit;
				} else if (gauche.isZero()) {
					return Entier.ZERO;
				} else {
					return this;
				}
				// ------- cas division
			} else if (op == Operator.DIV) {
				if (droit.isUnit()) {
					return gauche;
				} else if (gauche.isZero()) {
					return Entier.ZERO;
				} else {
					return this;
				}
			} else {
				return this;
			}
		}
	}

	/**
	 * The good solution.
	 *
	 * @return the term
	 */
	public Term engine() {
		Term gauche = left.engine();
		Term droit = right.engine();
		Binary b = new Binary(gauche, this.op, droit);
		return b.oneReduction();
	}



}
