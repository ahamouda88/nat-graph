package com.natera.graph.test;

import java.util.List;

import com.natera.graph.impl.DirectedGraph;
import com.natera.graph.impl.inter.IUnweightedGraph;
import com.natera.graph.model.GenEdge;
import com.natera.graph.model.algo.BFSGraphTraversal;
import com.natera.graph.model.algo.IGraphAlgorithm;

public class DirectedGraphTest {

	public static void main(String[] args){
		
		IGraphAlgorithm<Character> algo = new BFSGraphTraversal<Character>();
		IUnweightedGraph<Character> graph = new DirectedGraph<Character>(algo);
		
		try{
			graph.addVertex(null);
		}catch(NullPointerException ex){
			System.out.println("Null Pointer Exception is Thrown!!!!");
		}
		
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
