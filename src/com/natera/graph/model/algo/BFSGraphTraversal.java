package com.natera.graph.model.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.natera.graph.model.GenEdge;
import com.natera.graph.model.GenVertex;
import com.natera.graph.util.ParametersUtil;

/**
 * This <tt>BFSGraphTraversal</tt> class is used to traverse the Graph using the Breadth 
 * First Search Algorithm.
 * 
 * @param <T> vertex data type.
 */
public class BFSGraphTraversal<T> implements IGraphAlgorithm<T>{

	private final Queue<GenVertex<T>> queue;
	private final Set<GenVertex<T>> visited;
	
	public BFSGraphTraversal() {
		queue = new LinkedList<GenVertex<T>>();
		visited = new HashSet<GenVertex<T>>();
	}
	
	@Override
	public synchronized List<GenEdge<T>> traverseGraph(GenVertex<T> source, GenVertex<T> destination, 
			Map<GenVertex<T>, List<GenEdge<T>>> graphRep) {
		
		ParametersUtil.checkNullParameters(source, destination, graphRep);
		List<GenEdge<T>> resultEdges = new LinkedList<GenEdge<T>>();
		
		queue.add(source);
		int count = 1;
		int level = 1;
		Map<Integer, List<GenEdge<T>>> edgesByLevel = new HashMap<Integer, List<GenEdge<T>>>();
		List<GenEdge<T>> tmpList = new LinkedList<GenEdge<T>>();
		
		/*
		 * First, we will iterate through vertices level by level, and store
		 * the list of edges in each level, this will help us while backtracking
		 * to the source vertex.
		 */
		boolean destFound = false;
		while(!queue.isEmpty()){
			GenVertex<T> currVertex = queue.poll();
			visited.add(currVertex);
			count--;
			List<GenEdge<T>> list = graphRep.get(currVertex);
			if(list != null){
				for(GenEdge<T> edge : list){
					// Checking if destination vertex is visited.
					if(!visited.contains(edge.getDestVertex())){					
						tmpList.add(edge);
						if(edge.getDestVertex().equals(destination)){
							destFound = true;
							break;
						}else{
							queue.add(edge.getDestVertex());
						}
					}
				}
			}
			if(destFound){
				edgesByLevel.put(level, tmpList);
				break;
			}else if(count == 0){					
				edgesByLevel.put(level, tmpList);
				level++;
				count = queue.size();
				tmpList = new LinkedList<GenEdge<T>>();
			}
		}
		
		/*
		 * Backtracking to find the list of edges between two vertices.
		 * Using the levelByLevel map.
		 */
		GenVertex<T> dest = destination;
		while(level > 0){
			tmpList = edgesByLevel.get(level);
			for(GenEdge<T> edge : tmpList){
				if(edge.getDestVertex().equals(dest)){
					resultEdges.add(0, edge);
					dest = edge.getSourceVertex();
				}
			}
			level--;
		}
		return resultEdges;
	}

}
