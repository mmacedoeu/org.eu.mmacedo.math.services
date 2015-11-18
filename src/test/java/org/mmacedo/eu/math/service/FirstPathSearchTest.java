package org.mmacedo.eu.math.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eu.mmacedo.math.domain.Graph;
import org.eu.mmacedo.math.service.FirstPathSearchService;
import org.junit.Test;

import static org.junit.Assert.*;

public class FirstPathSearchTest {

	@Test
	public final void testCall() {
		Graph graph = new Graph();
		//Entrada: origem: 1, destino: 4,		
		//caminhos: ( 1 -> (2, 3), 2 -> (4), 3->(5) )		
		
		List<String> paths1 = Arrays.<String>asList("2","3");
		graph.addEdge("1", paths1);
		graph.addEdge("2", "4");
		graph.addEdge("3", "5");		
		
		LinkedList<String> visited = new FirstPathSearchService().search(graph, "1", "4");
		System.out.println(visited);
		assertTrue(true);
	}

}
