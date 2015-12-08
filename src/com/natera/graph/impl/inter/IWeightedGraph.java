package com.natera.graph.impl.inter;

import java.util.List;

import com.natera.graph.model.WeightedEdge;

/**
 * The <tt>IWeightedGraph</tt> interface should be implemented for performing the main operations on 
 * an Weighted graph such as adding an edge or finding the path between two vertices. This interface 
 * extends the <tt>IGraph</tt> interface for common Graph operations.
 * 
 * @param <T> vertex type.
 */
public interface IWeightedGraph<T> extends IGraph<T>{
	
	/**
	 * This method is used to add a weighted edge between two vertices of a graph, 
	 * given the two vertices, that the edge should be added between, and the edge's weight.
	 * 
	 * @param srcVertex - source vertex.
	 * @param destVertex - destination vertex.
	 * @param weight - edge weight
	 * @return true if edge is added successfully, otherwise it will return false.
	 * @throws NullPointerException is thrown if srcVertex or destVertex is <tt>null</tt>.
	 */
	public boolean addEdge(T srcVertex, T destVertex, double weight) throws NullPointerException;

	
	/**
	 * This method is used to get the path between two vertices, given the two vertices, it 
	 * will return the list of weighted edges between these two vertices.
	 * 
	 * @param srcVertex - source vertex.
	 * @param destVertex - destination vertex.
	 * @return list of weighted edges between the two vertices. Returns <tt>null</tt> 
	 * if any of the vertices is null.
	 */
	public List<WeightedEdge<T>> getPath(T vertex1, T vertex2);
}
