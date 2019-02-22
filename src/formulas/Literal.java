package formulas;

/**
 * Literal class represent the smallest part from a formula. It is denoted by x
 * followed by its id and preceded by ~ if it's in negative form.
 * 
 * @author razvan
 *
 */
public class Literal {

	/**
	 * The ID of the literal
	 */
	private int ID;

	/**
	 * Whether is in direct form or negative form.
	 */
	private boolean isNot;

	/**
	 * Create a new literal.
	 * 
	 * @param ID
	 *            the ID of the literal
	 * @param isNot
	 *            whether is in directed (false) form or negative form (true).
	 */
	public Literal(int ID, boolean isNot) {
		this.ID = ID;
		this.isNot = isNot;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (isNot) {
			return "~x" + ID;
		} else {
			return "x" + ID;
		}
	}
}
