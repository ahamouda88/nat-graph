package com.natera.graph.util;

import com.natera.graph.model.GenEdge;
import com.natera.graph.model.GenVertex;
import com.natera.graph.model.WeightedEdge;

/**
 * This <tt>GraphFactory</tt> is responsible for creating Vertex, and Edge Objects.
 * 
 */
public final class GraphFactory {

	/**
	 * This method is used to create a new GenVertex object, given the data for this vertex.
	 * 
	 * @param data - data of a vertex.
	 * @return new created vertex. Returns <tt>null</tt> if data is null.
	 */
	public static <T> GenVertex<T> createVertex(T data){
		GenVertex<T> newVertex = null;
		if(data != null){
			newVertex = new GenVertex<T>(data);
		}
		return newVertex;
	}
	
	/**
	 * This method is used to create an unweighted edge, given the source and destination vertices,
	 * and edge type. 
	 * 
	 * @param vertex1 - source vertex.
	 * @param vertex2 - destination vertex.
	 * @return new created unweighted edge. Returns <tt>null</tt> any given data is null.
	 */
	public static <T> GenEdge<T> createUnweightedEdge(GenVertex<T> vertex1, GenVertex<T> vertex2){
		GenEdge<T> newEdge = null;
		if(vertex1 != null && vertex2 != null){
			newEdge = new GenEdge<T>(vertex1, vertex2);
		}
		return newEdge;
	}
	
	/**
	 * This method is used to create an weighted edge, given the source and destination vertices,
	 * and edge type. Returns <b>null</b> any given data is null.
	 * 
	 * @param vertex1 - source vertex.
	 * @param vertex2 - destination vertex.
	 * @param weight - the weight of the edge.
	 * @return new created weighted edge.
	 */
	public static <T> WeightedEdge<T> createWeightedEdge(GenVertex<T> vertex1, GenVertex<T> vertex2, double weight){
		WeightedEdge<T> newEdge = null;
		if(vertex1 != null && vertex2 != null){
			newEdge = new WeightedEdge<T>(vertex1, vertex2, weight);
		}
		return newEdge;
	}
}
