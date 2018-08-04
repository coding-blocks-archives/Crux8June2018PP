package L24_Aug4;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 04-Aug-2018
 */

public class GraphClient {

	public static void main(String[] args) {

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
		graph.addEdge("C", "B", 4);
		graph.addEdge("C", "D", 5);
		graph.addEdge("D", "E", 6);
		graph.addEdge("E", "F", 7);
		graph.addEdge("G", "E", 8);
		graph.addEdge("F", "G", 9);

		graph.display();

		System.out.println(graph.numEdges());
		System.out.println(graph.numVertex());
		System.out.println(graph.containsEdge("A", "C"));
		System.out.println(graph.containsVertex("Y"));

		// graph.removeEdge("D", "E");

		graph.display();

		// System.out.println(graph.hasPath("A", "F", new HashMap<>()));
		System.out.println(graph.BFS("A", "F"));

		System.out.println(graph.DFS("A", "F"));

		graph.BFT();
		System.out.println("---");
		graph.DFT();

	}

}
