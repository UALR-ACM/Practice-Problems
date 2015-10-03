import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


/**
 * Problem J
 * Torn To Pieces
 *
 */
public class problemJ {

	public static void main(String[] args) {
		try {
			ArrayList<Node<String>> nodes = new ArrayList<Node<String>>();
			Scanner mrScan = new Scanner(System.in);
			int num = Integer.parseInt(mrScan.nextLine());
			while (num > 0) {
				String input = mrScan.nextLine();
				String[] iNodes = input.split(" ");
				for (int i = 0; i < iNodes.length; i++) {
					boolean found = false;
					for (Node<String> n : nodes) {
						if (n.name.equals(iNodes[i]))
							found = true;
					}

					Node<String> current = null;
					if (!found) {
						current = new Node<String>(iNodes[i]);
						nodes.add(current);
					} else {
						current = getNode(nodes, iNodes[i]);
					}

					if (i > 0) {
						Node<String> parent = getNode(nodes, iNodes[0]);
						parent.addChildren(current);
						current.addChildren(parent);
					}
				}
				num--;
			}
			String goals = mrScan.nextLine();

			String start = goals.split(" ")[0];
			String end = goals.split(" ")[1];
			Node<String> startNode = getNode(nodes, start);
			Node<String> endNode = getNode(nodes, end);

			ArrayDeque<Pair> queue = new ArrayDeque<Pair>();
			HashSet<Node<String>> closed = new HashSet<Node<String>>();
			queue.push(new Pair(startNode, null));
			String finalSol = "";
			while (!queue.isEmpty()) {
				Pair curNode = queue.pop();
				if (closed.contains(curNode.current)) {
					continue;
				}
				for (Node<String> child : curNode.current.children) {
					queue.add(new Pair(child, curNode));
				}
				if (curNode.current == endNode) {
					Pair curPair = curNode;
					while (curPair != null) {
						finalSol = curPair.current.name + " " + finalSol;
						curPair = curPair.parent;
					}
					break;
				}
				closed.add(curNode.current);
			}

			if (finalSol.length() <= 1) {
				System.out.println("no route found");
			} else {
				System.out.println(finalSol.trim());
			}
			mrScan.close();
		} catch (Exception e) {
			System.out.println("no route found");
		}
	}

	private static Node<String> getNode(ArrayList<Node<String>> nodes,
			String nodeName) {
		for (Node<String> n : nodes) {
			if (n.name.equals(nodeName))
				return n;
		}
		return null;
	}

}

class Pair {

	Node<String> current;
	Pair parent;

	public Pair(Node<String> current, Pair curNode) {
		this.current = current;
		this.parent = curNode;
	}

}

class Node<T> {

	public Node(T nodeName) {
		this.name = nodeName;
		children = new ArrayList<Node<T>>();
	}

	public void addChildren(Node<T> current) {
		children.add(current);
	}

	ArrayList<Node<T>> children;
	public T name;

}
