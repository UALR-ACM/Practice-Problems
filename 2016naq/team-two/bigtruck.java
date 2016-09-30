import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;


public class bigtruck {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numNodes = scan.nextInt();
		ArrayList<Node> nodes = new ArrayList<Node>(numNodes);
		for (int i = 1; i <= numNodes; i++) {
			nodes.add(new Node(i, scan.nextInt()));
		}
		int numEdges = scan.nextInt();
		for (int i = 1; i <= numEdges; i++) {
			int nodeA = scan.nextInt();
			int nodeB = scan.nextInt();
			int w = scan.nextInt();
			Node a = getNode(nodes, nodeA);
			Node b = getNode(nodes, nodeB);
			a.addNeighbor(b,w);
			b.addNeighbor(a,w);
		}
		
		PriorityQueue<QueueItem> pq = new PriorityQueue<QueueItem>();
		
		
		HashSet<Node> closed = new HashSet<Node>();
		
		pq.offer(new QueueItem(getNode(nodes, 1),new Pair(getNode(nodes,1),null,0),0));
		String out = "";
		int minPath = Integer.MAX_VALUE;
		int maxItems = 0;
		while (!pq.isEmpty()) {
			QueueItem q = pq.poll();
			if (closed.contains(q.n)) {
				continue;
			}
			for (Edge neigh : q.n.e) {
				pq.offer(new QueueItem(neigh.n, new Pair(neigh.n, q.parent, neigh.w + q.dist), q.dist + neigh.w));
			}
			if (q.n.name == numNodes) {
				Pair curPair = q.parent;
				int items = 0;
				while (curPair != null) {
					items += curPair.current.items;
					curPair = curPair.parent;
				}
				System.out.println(q.dist + " " + items);
				if (q.dist < minPath) {
					minPath = q.dist;
					maxItems = items;
				}
				if (q.dist == minPath) {
					if (items > maxItems) {
						minPath = q.dist;
						maxItems = items;
					}
				}
				out += "   " + (q.dist + " " + items);
				
			} else {
				closed.add(q.n);
			}
		}
		if (minPath == Integer.MAX_VALUE) 
			System.out.println("impossible");
		else
			System.out.println(minPath + " " + maxItems);
		scan.close();
	}
	private static Node getNode(ArrayList<Node> nodes, int name) {
		// TODO Auto-generated method stub
		for (Node n : nodes) {
			if (n.name == name) 
				return n;
		}
		return null;
	}
	static class QueueItem implements Comparable<QueueItem> {
		Node n;
		int dist;
		Pair parent;
		public QueueItem(Node n, Pair parent, int dist) {
			this.n = n;
			this.dist = dist;
			this.parent = parent;
		}
		@Override
		public int compareTo(QueueItem q) {
			return this.dist - q.dist;
			
		}
		
	}
	static class Pair {
		Node current;
		Pair parent;
		int w;
		public Pair(Node node, Pair parent, int w) {
			this.current = node;
			this.parent = parent;
			this.w = w;
		}
		
	}
	static class Node {
		int name;
		int items;
		ArrayList<Edge> e = new ArrayList<Edge>();
		public Node(int i, int nextInt) {
			name = i;
			items = nextInt;
		}
		public void addNeighbor(Node a, int w) {
			
			e.add(new Edge(a,w));
		}
	}
	static class Edge {
		Node n;
		int w;
		public Edge(Node a, int w) {
			this.n = a;
			this.w = w;
		}
		
	}
}
