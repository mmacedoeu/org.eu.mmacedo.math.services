package org.eu.mmacedo.math.service;

import java.util.LinkedList;
import java.util.List;

import org.eu.mmacedo.math.domain.Graph;

/**
 * Procura primeiro caminho através de uma busca BFS. Melhorias: o algoritmo pode
 * ser melhorado para fazer busca em paralelo ou mesmo no universo Hadoop como
 * em https://hama.apache.org/
 * 
 * @author macedo
 *
 */
public class FirstPathSearchService {

	public LinkedList<String> search(List<Object> content) {
		String start = (String) content.get(0);
		String end = (String) content.get(1);
		Graph graph = (Graph) content.get(2);

		return search(graph, start, end);
	}

	public LinkedList<String> search(Graph graph, String start, String end) {
		LinkedList<String> visited = new LinkedList<>();
		visited.add(start);
		call(graph, visited, end);
		return visited;
	}

	public Boolean call(Graph graph, LinkedList<String> visited, String END) {
		LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());

		for (String node : nodes) {
			if (visited.contains(node)) {
				continue;
			}
			if (node.equals(END)) {
				visited.add(node);
				System.out.println(visited);
				// visited.removeLast();
				// break;
				return true;
			}
		}

		for (String node : nodes) {
			if (visited.contains(node) || node.equals(END)) {
				continue;
			}
			visited.addLast(node);
			if (call(graph, visited, END))
				return true;
			visited.removeLast();
		}

		return false;
	}

}
