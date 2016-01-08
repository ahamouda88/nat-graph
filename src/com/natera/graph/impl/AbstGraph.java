package com.natera.graph.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.natera.graph.impl.inter.IGraph;
import com.natera.graph.model.GenEdge;
import com.natera.graph.model.GenVertex;
import com.natera.graph.model.algo.IGraphAlgorithm;
import com.natera.graph.util.GraphFactory;
import com.natera.graph.util.ParametersUtil;

/**
 * The <tt>AbstGraph</tt> abstract class is responsible for implementing 
 * the common operations of the graph. It implements the <tt>IGraph</tt> interface.
 * The graph is represented using an adjacent list.
 * 
 * @param <T> vertex type.
 */
public abstract class AbstGraph<T> implements IGraph<T>{

	protected final Map<GenVertex<T>, List<GenEdge<T>>> graphRep = new HashMap<GenVertex<T>, List<GenEdge<T>>>();
	protected final Map<T, GenVertex<T>> vertexMap = new HashMap<T, GenVertex<T>>();
	protected final IGraphAlgorithm<T> graphAlgorithm;
	
	public AbstGraph(IGraphAlgorithm<T> graphAlgorithm) {
		this.graphAlgorithm = graphAlgorithm;
	}
	
	@Override	
	public synchronized boolean addVertex(T data) throws NullPointerException{
		boolean result = false;
		ParametersUtil.checkNullParameters(data);
		
		// Checking if vertex already exists.
		if(!vertexMap.containsKey(data)){
			GenVertex<T> vertex = GraphFactory.createVertex(data);
			if(vertex != null){
				graphRep.put(vertex, new LinkedList<GenEdge<T>>());
				vertexMap.put(data, vertex);
				result = true;
			}
		}
		return result;
	}
	
	protected synchronized GenVertex<T> validateVertex(T data){
		GenVertex<T> vertex = vertexMap.get(data);
		if(vertex == null){
			addVertex(data);
			vertex = vertexMap.get(data);
		}
		return vertex;
	}
	
	protected synchronized boolean addEdgeToVertex(GenVertex<T> srcVertex, GenVertex<T> destVertex){
		boolean result = false;
		GenEdge<T> newEdge = GraphFactory.createUnweightedEdge(srcVertex, destVertex);
		if(newEdge != null){
			List<GenEdge<T>> vertexEdges = graphRep.get(srcVertex);			
			result = vertexEdges.add(newEdge);
		}
		return result;
	}
	
	public IGraphAlgorithm<T> getGraphAlgorithm() {
		return graphAlgorithm;
	}
}
