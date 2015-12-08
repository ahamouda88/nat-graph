package com.natera.graph.test;

import java.util.List;

import com.natera.graph.impl.UnDirectedGraph;
import com.natera.graph.impl.inter.IUnweightedGraph;
import com.natera.graph.model.GenEdge;
import com.natera.graph.model.algo.BFSGraphTraversal;
import com.natera.graph.model.algo.IGraphAlgorithm;

/**
 * Preferred to use main methods instead of using JUnit because executable files
 * such as the JUnit jar file, might not be able to download it from my email.
 * 
 */
public class UnDirectedGraphTest {

	public static void main(String[] args){
		IGraphAlgorithm<Character> algo = new BFSGraphTraversal<Character>();
		IUnweightedGraph<Character> graph = new UnDirectedGraph<Character>(algo);
		
		graph.addVertex('A');
		graph.addVertex('B');
		graph.addVertex('C');
		graph.addVertex('D');
		
		graph.addEdge('A', 'B');
		graph.addEdge('C', 'A');
		graph.addEdge('A', 'D');
		graph.addEdge('D','C');
		graph.addEdge('B', 'D');
		
		List<GenEdge<Character>> result = graph.getPath('A', 'C'); 
		for(GenEdge<Character> edge : result){
			System.out.println(edge);
		}
	}
}
