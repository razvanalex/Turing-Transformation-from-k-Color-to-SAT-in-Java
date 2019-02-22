package mainPackage;

import formulas.*;
import graph.*;

/**
 * Transformation class in the transformation that takes a graph and an number k
 * and returns a formulas. It is used to prove the polynomial reduction between
 * k-Colorability and SAT. This class implements a singleton design pattern.
 * 
 * @author razvan
 *
 */
public class Transformation {

	/**
	 * The instance of Transformation, thus it is a singleton.
	 */
	private static Transformation instance = null;

	/**
	 * Create a new instance.
	 */
	private Transformation() {
	}

	/**
	 * Create a new instance, or get the existing one.
	 * 
	 * @return an instance of Transformation
	 */
	public static Transformation getInstance() {
		if (instance == null) {
			instance = new Transformation();
		}

		return instance;
	}

	/**
	 * This method implements the transformation between k-Coloability and SAT.
	 * It take a graph and a number k of colors and it generates a formula that
	 * follows the next rule: k-Color(G=(V,E), k) = 1 &lt;=&gt; SAT(T(G, k)) = 1
	 * where T is this transformation. Details about this transformation may be
	 * found in README.
	 * 
	 * @param G
	 *            a graph
	 * @param k
	 *            number of colors
	 * @return a formula in CNF
	 */
	public Formulas kColorToSAT(UndirectedGraph G, int k) {
		Formulas fi = new Formulas();
		int numVertices = G.getNumVertices();
		boolean[] visited = new boolean[numVertices];

		for (int i = 0; i < numVertices; i++) {
			Clause c = new Clause();

			for (int j = 0; j < k; j++) {
				c.addLiterals(i * k + j, false);
			}

			visited[i] = false;
			fi.addClause(c);
		}

		for (int i = 0; i < numVertices; i++) {
			for (int c1 = 0; c1 < k; c1++) {
				for (int c2 = c1 + 1; c2 < k; c2++) {
					Clause c = new Clause();

					c.addLiterals(i * k + c1, true);
					c.addLiterals(i * k + c2, true);

					fi.addClause(c);
				}
			}

		}

		for (Vertex v : G.getVertices()) {
			visited[v.getID()] = true;

			for (Vertex neighbor : v.getNeighbors()) {
				if (!visited[neighbor.getID()]) {
					for (int i = 0; i < k; i++) {
						Clause c = new Clause();
						c.addLiterals(v.getID() * k + i, true);
						c.addLiterals(neighbor.getID() * k + i, true);
						fi.addClause(c);
					}
				}
			}
		}

		return fi;
	}

}
