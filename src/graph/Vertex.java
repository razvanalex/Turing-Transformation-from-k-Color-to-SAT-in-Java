package graph;

import java.util.ArrayList;

/**
 * Vertex class is the representation of a vertex from an undirected graph.
 * 
 * @author razvan
 *
 */
public class Vertex {

	/**
	 * The ID of the vertex
	 */
	private int ID;

	/**
	 * Array of neighbor vertices.
	 */
	private ArrayList<Vertex> neighbors;

	/**
	 * Create a new Vertex and set ID and initialize neighbors array.
	 * 
	 * @param ID
	 *            the ID of the vertex
	 */
	public Vertex(int ID) {
		this.ID = ID;
		neighbors = new ArrayList<Vertex>();
	}

	/**
	 * Getter for ID of the vertex.
	 * 
	 * @return the ID of the vertex
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Getter for array of vertices neighbors.
	 * 
	 * @return array of neighbors of current vertex
	 */
	public ArrayList<Vertex> getNeighbors() {
		return neighbors;
	}

	/**
	 * This function adds a neighbor to the array of neighbors. The addition is
	 * for both directions (from this to v and from v to this).
	 * 
	 * @param v
	 *            a neighbor vertex
	 */
	public void addNeighbor(Vertex v) {
		if (!this.neighbors.contains(v)) {
			this.neighbors.add(v);
			v.addNeighbor(this);
		}
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
		result = prime * result + ID;
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
		Vertex other = (Vertex) obj;
		if (ID != other.ID)
			return false;
		return true;
	}

}
