package L24_Aug4;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 04-Aug-2018
 */

public class Graph {

	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	private HashMap<String, Vertex> vertices = new HashMap<>();

	public int numVertex() {
		return vertices.size();
	}

	public boolean containsVertex(String vname) {
		return vertices.containsKey(vname);
	}

	public void addVertex(String vname) {

		Vertex vtx = new Vertex();
		vertices.put(vname, vtx);

	}

	public void removeVertex(String vname) {

		if (!vertices.containsKey(vname)) {
			return;
		}

		for (String nbr : vertices.get(vname).nbrs.keySet()) {

			Vertex vtx = vertices.get(nbr);
			vtx.nbrs.remove(vname);
		}

		vertices.remove(vname);

	}

	public int numEdges() {

		int ans = 0;

		for (String key : vertices.keySet()) {

			Vertex vtx = vertices.get(key);
			ans += vtx.nbrs.size();
		}

		return ans / 2;
	}

	public boolean containsEdge(String vname1, String vname2) {

		Vertex vtx1 = vertices.get(vname1);
		Vertex vtx2 = vertices.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return false;
		}

		return true;

	}

	public void addEdge(String vname1, String vname2, int cost) {

		Vertex vtx1 = vertices.get(vname1);
		Vertex vtx2 = vertices.get(vname2);

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.put(vname2, cost);
		vtx2.nbrs.put(vname1, cost);

	}

	public void removeEdge(String vname1, String vname2) {

		Vertex vtx1 = vertices.get(vname1);
		Vertex vtx2 = vertices.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);

	}

	public void display() {

		System.out.println("-----------------------");

		for (String key : vertices.keySet()) {

			Vertex vtx = vertices.get(key);
			System.out.println(key + " -> " + vtx.nbrs);
		}

		System.out.println("-----------------------");
	}

	public boolean hasPath(String src, String dst, HashMap<String, Boolean> processed) {

		// 0. processed put
		processed.put(src, true);

		// 1. direct edge
		if (containsEdge(src, dst)) {
			return true;
		}

		// 2. nbrs
		Vertex vtx = vertices.get(src);
		for (String nbr : vtx.nbrs.keySet()) {

			if (!processed.containsKey(nbr) && hasPath(nbr, dst, processed)) {
				return true;
			}

		}

		return false;

	}

	private class Pair {
		String vname;
		String psf;
	}

	public boolean BFS(String src, String dst) {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		// 1. make a pair and put in queue
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;
		queue.addLast(sp);

		// while queue is not empty keep on removing the pairs
		while (!queue.isEmpty()) {

			// remove the pair
			Pair rp = queue.removeFirst();

			if (processed.containsKey(rp.vname)) {
				continue;
			}

			// 1. put in processed
			processed.put(rp.vname, true);

			// 2. direct edge
			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			// 3. nbrs
			Vertex vtx = vertices.get(rp.vname);

			// loop on nbrs
			for (String nbr : vtx.nbrs.keySet()) {

				// process only unprocessed nbrs
				if (!processed.containsKey(nbr)) {

					// make a nbr pair and put in queue
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;

					queue.addLast(np);
				}
			}

		}

		return false;

	}

	public boolean DFS(String src, String dst) {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		// 1. make a pair and put in queue
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;
		stack.addFirst(sp);

		// while queue is not empty keep on removing the pairs
		while (!stack.isEmpty()) {

			// remove the pair
			Pair rp = stack.removeFirst();

			if (processed.containsKey(rp.vname)) {
				continue;
			}

			// 1. put in processed
			processed.put(rp.vname, true);

			// 2. direct edge
			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			// 3. nbrs
			Vertex vtx = vertices.get(rp.vname);

			// loop on nbrs
			for (String nbr : vtx.nbrs.keySet()) {

				// process only unprocessed nbrs
				if (!processed.containsKey(nbr)) {

					// make a nbr pair and put in queue
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;

					stack.addFirst(np);
				}
			}

		}

		return false;

	}

	public void BFT() {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		for (String key : vertices.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			// 1. make a pair and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			queue.addLast(sp);

			// while queue is not empty keep on removing the pairs
			while (!queue.isEmpty()) {

				// remove the pair
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				// 1. put in processed
				processed.put(rp.vname, true);

				// 2. syso
				System.out.println(rp.vname + " via " + rp.psf);

				// 3. nbrs
				Vertex vtx = vertices.get(rp.vname);

				// loop on nbrs
				for (String nbr : vtx.nbrs.keySet()) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {

						// make a nbr pair and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						queue.addLast(np);
					}
				}

			}

		}
	}

	public void DFT() {

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		for (String key : vertices.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			// 1. make a pair and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			stack.addFirst(sp);

			// while queue is not empty keep on removing the pairs
			while (!stack.isEmpty()) {

				// remove the pair
				Pair rp = stack.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				// 1. put in processed
				processed.put(rp.vname, true);

				// 2. syso
				System.out.println(rp.vname + " via " + rp.psf);

				// 3. nbrs
				Vertex vtx = vertices.get(rp.vname);

				// loop on nbrs
				for (String nbr : vtx.nbrs.keySet()) {

					// process only unprocessed nbrs
					if (!processed.containsKey(nbr)) {

						// make a nbr pair and put in queue
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						stack.addFirst(np);
					}
				}

			}

		}
	}


}
