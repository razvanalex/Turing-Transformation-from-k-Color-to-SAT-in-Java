package graph;

import java.util.ArrayList;

/**
 * UndirectedGraph class is a representation of an undirected graph that
 * contains an array of vertices and an array of edges. The graph constructed
 * cannot be resized in this implementation. Any vertices has an array of
 * neighbors, that may represent the edges. Also, for speed purpose and for
 * theoretical purpose, there is an array of edges.
 * 
 * @author razvan
 *
 */
public class UndirectedGraph {

	/**
	 * The number of vertices of the graph
	 */
	private int numVertices;

	/**
	 * The array of vertices of the graph
	 */
	private ArrayList<Vertex> vertices;

	/**
	 * The array of edges of the graph.
	 */
	private ArrayList<Edge> edges;

	/**
	 * Create a new undirected graph with numVertices vertices. Each vertex is
	 * indexed from 0 to numVertices.
	 * 
	 * @param numVertices
	 *            the number of vertices
	 */
	public UndirectedGraph(int numVertices) {
		this.numVertices = numVertices;
		vertices = new ArrayList<Vertex>(numVertices);
		edges = new ArrayList<Edge>();

		for (int i = 0; i < numVertices; i++) {
			vertices.add(new Vertex(i));
		}
	}

	/**
	 * Get a vertex form vertex array, by its ID
	 * 
	 * @param ID
	 *            the id of the vertex
	 * @return the vertex with a specified ID
	 */
	private Vertex getVertexByID(int ID) {
		for (Vertex v : vertices) {
			if (v.getID() == ID) {
				return v;
			}
		}

		return null;
	}

	/**
	 * Add a new edge in graph.
	 * 
	 * @param ID1
	 *            the ID of first vertex
	 * @param ID2
	 *            the ID of the second vertex
	 */
	public void addEdge(int ID1, int ID2) {
		Vertex v1 = getVertexByID(ID1);
		Vertex v2 = getVertexByID(ID2);

		v1.addNeighbor(v2);
		edges.add(new Edge(v1, v2));
	}

	/**
	 * Getter for numVertices.
	 * 
	 * @return the number of vertices form graph
	 */
	public int getNumVertices() {
		return numVertices;
	}

	/**
	 * Getter for vertices array.
	 * 
	 * @return the array of vertices of a graph
	 */
	public ArrayList<Vertex> getVertices() {
		return vertices;
	}

	/**
	 * Getter for edges array.
	 * 
	 * @return the array of edges of a graph
	 */
	public ArrayList<Edge> getEdges() {
		return edges;
	}
}
