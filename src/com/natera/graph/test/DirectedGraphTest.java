package com.natera.graph.test;

import java.util.List;

import com.natera.graph.impl.DirectedGraph;
import com.natera.graph.impl.inter.IUnweightedGraph;
import com.natera.graph.model.GenEdge;
import com.natera.graph.model.algo.BFSGraphTraversal;
import com.natera.graph.model.algo.IGraphAlgorithm;
/**
 * Preferred to use main methods instead of using JUnit because executable files
 * such as the JUnit jar file, might not be able to download it from my email.
 * 
 */
public class DirectedGraphTest {

	public static void main(String[] args){
		/*GenVertex<Character> a = GraphFactory.createVertex('A');
		GenVertex<Character> b = GraphFactory.createVertex('B');
		GenVertex<Character> c = GraphFactory.createVertex('C');
		GenVertex<Character> d = GraphFactory.createVertex('D');

		GenEdge<Character> edgeAB = GraphFactory.createUnweightedEdge(a, b);
		GenEdge<Character> edgeAC = GraphFactory.createUnweightedEdge(a, c);
		GenEdge<Character> edgeAD = GraphFatory.createUnweightedEdge(a, d);
		GenEdge<Character> edgeBD = GraphFactory.createUnweightedEdge(b, d);
		GenEdge<Character> edgeCD = GraphFactory.createUnweightedEdge(c, d);*/
		
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
