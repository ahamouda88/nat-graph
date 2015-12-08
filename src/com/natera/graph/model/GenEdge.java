package com.natera.graph.model;

/**
 * The <tt>GenEdge</tt> class represents the main properties of an Edge between two vertices. 
 *
 * @param <T> vertex data type.
 */
public class GenEdge<T> {
	
	private GenVertex<T> sourceVertex;
	private GenVertex<T> destVertex;

	public GenEdge(GenVertex<T> sourceVertex, GenVertex<T> destVertex) {
		this.sourceVertex = sourceVertex;
		this.destVertex = destVertex;
	}

	public GenVertex<T> getSourceVertex() {
		return sourceVertex;
	}
	
	public void setSourceVertex(GenVertex<T> sourceVertex) {
		this.sourceVertex = sourceVertex;
	}
	
	public GenVertex<T> getDestVertex() {
		return destVertex;
	}
	
	public void setDestVertex(GenVertex<T> destVertex) {
		this.destVertex = destVertex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((destVertex == null) ? 0 : destVertex.hashCode());
		result = prime * result
				+ ((sourceVertex == null) ? 0 : sourceVertex.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		GenEdge<T> other = (GenEdge<T>) obj;
		if (destVertex == null) {
			if (other.destVertex != null)
				return false;
		} else if (!destVertex.equals(other.destVertex))
			return false;
		if (sourceVertex == null) {
			if (other.sourceVertex != null)
				return false;
		} else if (!sourceVertex.equals(other.sourceVertex))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Edge From: ");
		sb.append(sourceVertex.getData());
		sb.append(" To ");
		sb.append(destVertex.getData());
		return sb.toString();
	}
}
