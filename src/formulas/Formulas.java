package formulas;

import java.util.ArrayList;

/**
 * Formulas class represents a data type used to represent a formulas in
 * conjunctive normal form (CNF). A formula is formed with clauses that contains
 * literals separated by OR (V). All clauses are separated by AND (^). The
 * general form of a CNF formula is: c1 ^ c2 ^ ... ^ cn, where ci = li1 V li2 V
 * ... V lim, and lij is x or ~x, a literal.
 * 
 * @author razvan
 *
 */
public class Formulas {

	/**
	 * An array of clauses that represents the formulas.
	 */
	private ArrayList<Clause> clauses;

	/**
	 * Create a new formula in CNF, the empty formula.
	 */
	public Formulas() {
		clauses = new ArrayList<Clause>();
	}

	/**
	 * Add a new clause to the formula.
	 * 
	 * @param c
	 *            a new clause
	 */
	public void addClause(Clause c) {
		clauses.add(c);
	}

	/**
	 * Getter for clauses array.
	 * 
	 * @return the array of clauses form the formula.
	 */
	public ArrayList<Clause> getClauses() {
		return clauses;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (Clause c : clauses) {
			if (c.getLiterals().size() > 1) {
				sb.append("(" + c.toString() + ")^");
			} else {
				sb.append(c.toString() + "^");
			}
		}

		String string = sb.toString();
		if (string.length() > 1)
			return string.substring(0, string.length() - 1);

		return null;
	}

}
