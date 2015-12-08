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

/**
 * The <tt>AbstGraph</tt> abstract class is responsible for implementing 
 * the common operations of the graph. It implements the <tt>IGraph</tt> interface.
 * The graph is represented using an adjacent list.
 * 
 * @param <T> vertex type.
 */
public abstract class AbstGraph<T> implements IGraph<T>{

	protected Map<GenVertex<T>, List<GenEdge<T>>> graphRep;
	protected Map<T, GenVertex<T>> vertexMap;
	protected IGraphAlgorithm<T> graphAlgorithm;
	
	public AbstGraph() {
		graphRep = new HashMap<GenVertex<T>, List<GenEdge<T>>>();
		vertexMap = new HashMap<T, GenVertex<T>>();	
	}
	
	@Override	
	public boolean addVertex(T data) throws NullPointerException{
		boolean result = false;
		// Checking if vertex already exists.
		if(data == null){
			throw new NullPointerException("Given data is Null!");
		}
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
	
	protected GenVertex<T> validateVertex(T data){
		GenVertex<T> vertex = vertexMap.get(data);
		if(vertex == null){
			addVertex(data);
			vertex = vertexMap.get(data);
		}
		return vertex;
	}
	
	protected boolean addEdgeToVertex(GenVertex<T> srcVertex, GenVertex<T> destVertex){
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

	public void setGraphAlgorithm(IGraphAlgorithm<T> graphAlgorithm) {
		this.graphAlgorithm = graphAlgorithm;
	}
}