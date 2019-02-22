package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Edge class represents an edge from a graph. An edge has 2 vertices that are
 * adjacent. Vertices are stored in a HashSet, to eliminate the possibility of
 * direction in the graph. In other words, (v1, v2) is the same as (v2, v1),
 * thus this is an unordered set.
 * 
 * @author razvan
 *
 */
public class Edge {

	/**
	 * A set of vertices. It should contain only two vertices.
	 */
	private HashSet<Vertex> vertices;

	/**
	 * Create a new edge between two vertices.
	 * 
	 * @param v1
	 *            the first vertex
	 * @param v2
	 *            the second vertex
	 */
	public Edge(Vertex v1, Vertex v2) {
		vertices = new HashSet<Vertex>();
		vertices.add(v1);
		vertices.add(v2);
	}

	/**
	 * Getter for vertex set
	 * 
	 * @return a set of two vertices
	 */
	public HashSet<Vertex> getVertices() {
		return vertices;
	}

	/**
	 * Getter of vertex set, that converts the set into an array.
	 * 
	 * @return and array of two vertices. The order does not matter at all.
	 */
	public ArrayList<Vertex> getVerticesArrayList() {
		ArrayList<Vertex> array = new ArrayList<>(2);
		Iterator<Vertex> itr = vertices.iterator();

		while (itr.hasNext()) {
			array.add(itr.next());
		}

		return array;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((vertices == null) ? 0 : vertices.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (vertices == null) {
			if (other.vertices != null)
				return false;
		} else if (!vertices.equals(other.vertices))
			return false;
		return true;
	}

}
