package L24_Aug4;

import java.util.Queue;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 04-Aug-2018
 */

public class GraphClient {

	public static void main(String[] args) {

		for (String val : args) {
			System.out.println(val);
		}
		Graph graph = new Graph();

		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");

		graph.addEdge("A", "B", 2);
		graph.addEdge("A", "D", 3);
		graph.addEdge("C", "B", 1);
		graph.addEdge("C", "D", 4);
		graph.addEdge("D", "E", 5);
		graph.addEdge("E", "F", 7);
		graph.addEdge("G", "E", 2);
		graph.addEdge("F", "G", 3);

		graph.display();

		System.out.println(graph.numEdges());
		System.out.println(graph.numVertex());
		System.out.println(graph.containsEdge("A", "C"));
		System.out.println(graph.containsVertex("Y"));

		// graph.removeEdge("B", "C");
		// graph.removeEdge("F", "G");
		// graph.removeEdge("D", "E");

		graph.display();

		// System.out.println(graph.hasPath("A", "F", new HashMap<>()));
		System.out.println(graph.BFS("A", "F"));

		System.out.println(graph.DFS("A", "F"));

		graph.BFT();
		System.out.println("---");
		graph.DFT();

		System.out.println("---");
		System.out.println(graph.isCyclic());
		System.out.println(graph.isConnected());
		System.out.println(graph.isTree());
		System.out.println(graph.getCC());

		System.out.println(graph.isBipartite());

		graph.Prims().display();
		System.out.println(graph.Dijkstra("A"));

	}

}
