package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	String name;
	ArrayList<Node> neighbors;
	int visited;
	
	public Node(String name){
		this.name = name;
		neighbors = new ArrayList<Node>();
		visited = 0;
	}
}

class Graph{
	Node source = null;
	ArrayList<Node> nodes = new ArrayList<Node>();
	
	public void addNode(Node newNode){
		nodes.add(newNode);
	}
	
	
	// BFS traversal
	public void BFSTraversal(Node source){
		this.source = source;
		
		Queue queue = new LinkedList();
		
		queue.add(source);
		
		while(!queue.isEmpty()){
			Node curr = (Node) queue.remove();
			if(curr.visited == 0){
				System.out.print(curr.name+", ");
				for(int i = 0; i < curr.neighbors.size(); i++){
					queue.add(curr.neighbors.get(i));
				}
				curr.visited = 1;
			}
		}
	}
	
	
	
	// DFS traversal
	public void DFSTraversal(Node source){
		this.source = source;
		
		for(int i = 0; i<nodes.size(); i++){
			if(nodes.get(i).visited == 0)
				DFS(nodes.get(i));
		}
		
	}
	
	private void DFS(Node curr){
		curr.visited = 1;
		System.out.print(curr.name+", ");
		for(int i = 0; i < curr.neighbors.size(); i++){
			if(curr.neighbors.get(i).visited == 0){
				DFS(curr.neighbors.get(i));
			}
		}
		curr.visited = 2; 	// blacken the node so that its job is completely done
	}
	
	
}

public class BFS {

	public static void main(String[] args) {
		
		// create a graph using adjacency list representation that we have formed
		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D");
		Node E = new Node("E");
		
		A.neighbors.add(B);
		A.neighbors.add(C);
		B.neighbors.add(D);
		B.neighbors.add(E);
		
		C.neighbors.add(E);
		
		D.neighbors.add(B);
		D.neighbors.add(A);
		
		Graph graph = new Graph();
		graph.addNode(A);
		graph.addNode(B);
		graph.addNode(C);
		graph.addNode(D);
		graph.addNode(E);
		//graph.BFSTraversal(A);
		
		graph.DFSTraversal(A);
		

	}

}
