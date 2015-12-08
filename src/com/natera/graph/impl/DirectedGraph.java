package com.natera.graph.impl;

import java.util.List;

import com.natera.graph.impl.inter.IUnweightedGraph;
import com.natera.graph.model.GenEdge;
import com.natera.graph.model.GenVertex;
import com.natera.graph.model.algo.BFSGraphTraversal;
import com.natera.graph.model.algo.IGraphAlgorithm;

/**
 * The <tt>DirectedGraph</tt> class represents a graph with directed and unweighted edges.
 * The default algorithm for traversing the graph is the Breadth First Algorithm.
 * 
 * @param <T> vertex type.
 */
public class DirectedGraph<T> extends AbstGraph<T> implements IUnweightedGraph<T> {
		
	public DirectedGraph() {
		super();
		graphAlgorithm = new BFSGraphTraversal<T>();
	}
	
	public DirectedGraph(IGraphAlgorithm<T> graphAlgorithm) {
		super();
		this.graphAlgorithm = graphAlgorithm;
	}
	
	@Override
	public boolean addEdge(T srcData, T destData) throws NullPointerException{
		boolean result = false;
		if(srcData != null && destData != null){
			GenVertex<T> srcVertex = validateVertex(srcData);
			GenVertex<T> destVertex = validateVertex(destData);
			
			result = this.addEdgeToVertex(srcVertex, destVertex);
		}else{
			throw new NullPointerException("Either Source Data or Destination Data is Null!");
		}
		return result;
	}

	@Override
	public List<GenEdge<T>> getPath(T srcData, T destData) {
		List<GenEdge<T>> listOfEdges = null;
		if(srcData != null && destData != null){
			GenVertex<T> vertex1 = vertexMap.get(srcData);
			GenVertex<T> vertex2 = vertexMap.get(destData);
			listOfEdges = graphAlgorithm.traverseGraph(vertex1, vertex2, graphRep);
		}
		return listOfEdges;
	}
	
}