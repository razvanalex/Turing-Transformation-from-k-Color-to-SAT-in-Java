package formulas;

import java.util.ArrayList;

/**
 * Clause class represents a clause inside a formula. It contains literals which
 * are delimited by parenthesis and OR disjunction.
 * 
 * @author razvan
 *
 */
public class Clause {

	/**
	 * Array of literals. They are printed separated by (V).
	 */
	private ArrayList<Literal> literals;

	/**
	 * Create a new empty clause.
	 */
	public Clause() {
		literals = new ArrayList<Literal>();
	}

	/**
	 * Add a new literal into a clause.
	 * 
	 * @param ID
	 *            the id of the literal
	 * @param isNot
	 *            is in direct form or negate form
	 * 
	 */
	public void addLiterals(int ID, boolean isNot) {
		literals.add(new Literal(ID, isNot));
	}

	/**
	 * Getter for literals.
	 * 
	 * @return an array of literals
	 */
	public ArrayList<Literal> getLiterals() {
		return literals;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (Literal l : literals) {
			sb.append(l.toString() + "V");
		}

		String string = sb.toString();
		if (string.length() > 1)
			return string.substring(0, string.length() - 1);

		return null;
	}

}
