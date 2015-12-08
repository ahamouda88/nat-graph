package com.natera.graph.model.algo;

import java.util.List;
import java.util.Map;

import com.natera.graph.model.GenEdge;
import com.natera.graph.model.GenVertex;

/**
 * This <tt>GraphAlgorithm</tt> should be implemented for traversing the Graph using a particular algorithm, 
 * and implementation. The graph is represented using an adjacent list.
 * 
 * @param <T> vertex data type.
 */
public interface IGraphAlgorithm<T>{

	/**
	 * This method is responsible for finding the path between two vertices and traverse the graph, 
	 * given the source, and destination vertices, and the graph representation.
	 * 
	 * @param source - source vertex.
	 * @param destination - destination vertex.
	 * @param graphRep - graph representation.
	 * @return list of edges between the given vertices, and returns null if any of the given arguments is <tt>null</tt>.
	 */
	public List<GenEdge<T>> traverseGraph(GenVertex<T> source, GenVertex<T> destination, Map<GenVertex<T>, List<GenEdge<T>>> graphRep);
}
