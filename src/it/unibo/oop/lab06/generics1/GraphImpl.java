package it.unibo.oop.lab06.generics1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphImpl<T> implements Graph<T>{
	private Map <T, Set<T>> nodeMap;
	
	public GraphImpl() {
		this.nodeMap = new HashMap <>();
	}

	public void addNode(T node) {
		if(node != null && !this.nodeMap.containsKey(node)) {
			this.nodeMap.put(node , new  HashSet<T>());
		}	
	}

	public void addEdge(T source, T target) {
		this.nodeMap.get(source).add(target);
	}

	public Set<T> nodeSet() {
		return this.nodeMap.keySet();
	}

	public Set<T> linkedNodes(T node) {
		return this.nodeMap.get(node);
	}

	public List<T> getPath(T source, T target) {
		return null;
	}

}
