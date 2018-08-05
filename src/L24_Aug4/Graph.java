package L24_Aug4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import L22_Aug1.HeapGeneric;

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
		String color;
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

	public boolean isCyclic() {

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
					return true;
				}

				// 1. put in processed
				processed.put(rp.vname, true);

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

		return false;
	}

	public boolean isConnected() {

		int flag = 0;

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		for (String key : vertices.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			flag++;

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

		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isTree() {

		return !isCyclic() && isConnected();
	}

	public ArrayList<ArrayList<String>> getCC() {

		ArrayList<ArrayList<String>> ans = new ArrayList<>();

		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		for (String key : vertices.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			ArrayList<String> subans = new ArrayList<>();

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

				// 2. put in subans
				subans.add(rp.vname);

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

			ans.add(subans);

		}

		return ans;
	}

	public boolean isBipartite() {

		HashMap<String, String> processed = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		for (String key : vertices.keySet()) {

			if (processed.containsKey(key)) {
				continue;
			}

			// 1. make a pair and put in queue
			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			sp.color = "r";
			queue.addLast(sp);

			// while queue is not empty keep on removing the pairs
			while (!queue.isEmpty()) {

				// remove the pair
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {

					String oc = processed.get(rp.vname);
					String nc = rp.color;

					if (!oc.equals(nc)) {
						return false;
					}
					continue;
				}

				// 1. put in processed
				processed.put(rp.vname, rp.color);

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

						String nc = rp.color.equals("r") ? "g" : "r";

						np.color = nc;
						queue.addLast(np);
					}
				}

			}

		}

		return true;

	}

	private class PrimsPair implements Comparable<PrimsPair> {
		String vname;
		String acqvtxname;
		int cost;

		@Override
		public int compareTo(PrimsPair o) {
			return o.cost - this.cost;
		}

	}

	public Graph Prims() {

		Graph mst = new Graph();

		HeapGeneric<PrimsPair> heap = new HeapGeneric<>();
		HashMap<String, PrimsPair> map = new HashMap<>();

		// make a pair and put in heap
		for (String key : vertices.keySet()) {

			PrimsPair np = new PrimsPair();
			np.vname = key;
			np.acqvtxname = null;
			np.cost = Integer.MAX_VALUE;

			// put in heap and map
			heap.add(np);
			map.put(key, np);
		}

		// work till heap is not empty
		while (!heap.isEmpty()) {

			// remove the pair from heap and map
			PrimsPair rp = heap.remove();
			map.remove(rp.vname);

			// add the removed pair to your mst
			if (rp.acqvtxname == null) {
				mst.addVertex(rp.vname);
			} else {
				mst.addVertex(rp.vname);
				mst.addEdge(rp.vname, rp.acqvtxname, rp.cost);
			}

			// update the nbrs
			for (String nbr : vertices.get(rp.vname).nbrs.keySet()) {

				// update only those nbrs which are present in heap
				if (map.containsKey(nbr)) {
					PrimsPair gp = map.get(nbr);

					// get the old cost and new cost
					int oc = gp.cost;
					int nc = vertices.get(rp.vname).nbrs.get(nbr);

					// if(nc < oc) then update the pair
					if (nc < oc) {
						gp.acqvtxname = rp.vname;
						gp.cost = nc;

						// update the priority of pair in heap
						heap.updatePriority(gp);
					}
				}

			}

		}

		// return mst
		return mst;

	}

	private class DijkstraPair implements Comparable<DijkstraPair> {
		String vname;
		String psf;
		int cost;

		@Override
		public int compareTo(DijkstraPair o) {
			return o.cost - this.cost;
		}

	}

	public HashMap<String, Integer> Dijkstra(String src) {

		HashMap<String, Integer> ans = new HashMap<>();

		HeapGeneric<DijkstraPair> heap = new HeapGeneric<>();
		HashMap<String, DijkstraPair> map = new HashMap<>();

		// make a pair and put in heap
		for (String key : vertices.keySet()) {

			DijkstraPair np = new DijkstraPair();
			np.vname = key;
			np.cost = Integer.MAX_VALUE;

			if (key.equals(src)) {
				np.cost = 0;
			}

			// put in heap and map
			heap.add(np);
			map.put(key, np);
		}

		// work till heap is not empty
		while (!heap.isEmpty()) {

			// remove the pair from heap and map
			DijkstraPair rp = heap.remove();
			map.remove(rp.vname);

			// add the removed pair to your ans
			ans.put(rp.vname, rp.cost);

			// update the nbrs
			for (String nbr : vertices.get(rp.vname).nbrs.keySet()) {

				// update only those nbrs which are present in heap
				if (map.containsKey(nbr)) {
					DijkstraPair gp = map.get(nbr);

					// get the old cost and new cost
					int oc = gp.cost;
					int nc = rp.cost + vertices.get(rp.vname).nbrs.get(nbr);

					// if(nc < oc) then update the pair
					if (nc < oc) {
						gp.psf = rp.psf + nbr;
						gp.cost = nc;

						// update the priority of pair in heap
						heap.updatePriority(gp);
					}
				}

			}

		}

		// return ans
		return ans;

	}

}
