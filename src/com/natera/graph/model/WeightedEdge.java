package com.natera.graph.model;

/**
 * The <tt>WeightedEdge</tt> class represents the properties of a Weighted Edge, 
 * and it inherits the properties of an edge. 
 *
 * @param <T> vertex type.
 */
public class WeightedEdge<T> extends GenEdge<T>{

	private double weight;
	
	public WeightedEdge(GenVertex<T> sourceVertex, GenVertex<T> destVertex, double weight) {
		super(sourceVertex,destVertex);
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}
