package com.natera.graph.impl.inter;

/**
 * The <tt>IGraph</tt> interface should be implemented for performing the main operations on 
 * a graph such as adding a vertex.
 * 
 * @param <T> vertex type.
 */
public interface IGraph<T> {
	
	/**
	 * This method is used to create and add a vertex to the graph, given the vertex data.
	 * 
	 * @param data - vertex data.
	 * @return true if vertex is added successfully, otherwise it will return false.
	 * @throws NullPointerException is thrown if vertex is <tt>null</tt>.
	 */
	public boolean addVertex(T data) throws NullPointerException;
	
}
