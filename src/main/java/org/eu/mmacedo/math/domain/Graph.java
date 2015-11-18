package org.eu.mmacedo.math.domain;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {
    private Map<String, LinkedHashSet<String>> map = new HashMap<>();

    public void addEdge(String node1, String node2) {
        LinkedHashSet<String> adjacent = map.get(node1);
        if(adjacent==null) {
            adjacent = new LinkedHashSet<>();
            map.put(node1.trim(), adjacent);
        }
        adjacent.add(node2.trim());
    }
    
    public void addEdge(String node1, List<String> paths) {
    	for (String node2 : paths) {
			addEdge(node1, node2);
		}
    }
    
    public void addEdge(Map<String, List<String>> paths) {
    	for (String node1 : paths.keySet()) {
    		addEdge(node1, paths.get(node1));			
		}
    }

    public boolean isConnected(String node1, String node2) {
        Set<?> adjacent = map.get(node1);
        if(adjacent==null) {
            return false;
        }
        return adjacent.contains(node2);
    }

    public LinkedList<String> adjacentNodes(String last) {
        LinkedHashSet<String> adjacent = map.get(last);
        if(adjacent==null) {
            return new LinkedList<>();
        }
        return new LinkedList<String>(adjacent);
    }
}