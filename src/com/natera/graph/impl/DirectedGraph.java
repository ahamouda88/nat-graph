package com.natera.graph.impl;

import java.util.List;

import com.natera.graph.impl.inter.IUnweightedGraph;
import com.natera.graph.model.GenEdge;
import com.natera.graph.model.GenVertex;
import com.natera.graph.model.algo.IGraphAlgorithm;
import com.natera.graph.util.ParametersUtil;

/**
 * The <tt>DirectedGraph</tt> class represents a graph with directed and unweighted edges.
 * The default algorithm for traversing the graph is the Breadth First Algorithm.
 * 
 * @param <T> vertex type.
 */
public class DirectedGraph<T> extends AbstGraph<T> implements IUnweightedGraph<T> {
	
	public DirectedGraph(IGraphAlgorithm<T> graphAlgorithm) {
		super(graphAlgorithm);
	}
	
	@Override
	public boolean addEdge(T srcData, T destData) throws NullPointerException{
		boolean result = false;		
		GenVertex<T> srcVertex = validateVertex(srcData);
		GenVertex<T> destVertex = validateVertex(destData);			
		result = this.addEdgeToVertex(srcVertex, destVertex);
		return result;
	}

	@Override
	public List<GenEdge<T>> getPath(T srcData, T destData) {		
		ParametersUtil.checkNullParameters(srcData, destData);
		
		List<GenEdge<T>> listOfEdges = null;
		GenVertex<T> vertex1 = vertexMap.get(srcData);
		GenVertex<T> vertex2 = vertexMap.get(destData);
		listOfEdges = graphAlgorithm.traverseGraph(vertex1, vertex2, graphRep);
		return listOfEdges;
	}
	
}
