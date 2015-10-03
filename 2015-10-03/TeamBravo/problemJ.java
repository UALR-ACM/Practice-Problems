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
			//Initialize arraylist of nodes to keep track of what we have seen.
			ArrayList<Node<String>> nodes = new ArrayList<Node<String>>();
			Scanner mrScan = new Scanner(System.in);
			int num = Integer.parseInt(mrScan.nextLine());
			while (num > 0) {
				String input = mrScan.nextLine();

				//Each line is represented as PARENT CHILD CHILD CHILD ...
				String[] iNodes = input.split(" ");
				for (int i = 0; i < iNodes.length; i++) {

					//Check to see if the node has already been created
					boolean found = false;
					for (Node<String> n : nodes) {
						if (n.name.equals(iNodes[i]))
							found = true;
					}

					//If the node hasn't been created, create it and set it to current.
					Node<String> current = null;
					if (!found) {
						current = new Node<String>(iNodes[i]);
						nodes.add(current);
					} else {
						current = getNode(nodes, iNodes[i]);
					}


					//If this isn't the parent node, add self to parent node
					if (i > 0) {
						Node<String> parent = getNode(nodes, iNodes[0]);
						parent.addChildren(current);
						current.addChildren(parent);
					}
				}
				num--;
			}

			//Read in the starting and ending goal
			String goals = mrScan.nextLine();

			String start = goals.split(" ")[0];
			String end = goals.split(" ")[1];

			//Find the start and end nodes within the node set
			Node<String> startNode = getNode(nodes, start);
			Node<String> endNode = getNode(nodes, end);

			//Setup a queue of Pair, which contains the current node and parent. 
			ArrayDeque<Pair> queue = new ArrayDeque<Pair>();

			//Create a hashset for the closed list 
			//Since this is undirected, the closed set is important
			HashSet<Node<String>> closed = new HashSet<Node<String>>();

			//Push the initial node onto the queue.
			queue.push(new Pair(startNode, null));

			//Empty solution answer
			String finalSol = "";

			//While the queue is not empty, keep popping nodes off of the queue.
			while (!queue.isEmpty()) {
				Pair curNode = queue.pop();

				//If the node has already been explored, ignore it.
				if (closed.contains(curNode.current)) {
					continue;
				}

				//Add the current node's children to the queue.
				for (Node<String> child : curNode.current.children) {
					queue.add(new Pair(child, curNode));
				}

				//If the current node is the goal, we have a solution.
				if (curNode.current == endNode) {
					Pair curPair = curNode;

					//Trace the parents of the current node to find the path it came from.
					while (curPair != null) {
						finalSol = curPair.current.name + " " + finalSol;
						curPair = curPair.parent;
					}
					break;
				}

				//If we didn't find anything, add it to closed list.
				closed.add(curNode.current);
			}


			if (finalSol.length() <= 1) {
				System.out.println("no route found");
			} else {
				System.out.println(finalSol.trim());
			}
			mrScan.close();

		//The beauty of ACM is contained in this line below:
		} catch (Exception e) {
			System.out.println("no route found");
		}

		/*
		Upon further review, the reason for the NullPointerException was because if either
		of the start or end goal nodes is not in the node set(which is a possibility), it
		the program wouldn't be able compare them in BFS
		*/
	}

	//Find node by a name
	private static Node<String> getNode(ArrayList<Node<String>> nodes,
			String nodeName) {
		for (Node<String> n : nodes) {
			if (n.name.equals(nodeName))
				return n;
		}
		return null;
	}

}

//Generic Pair class
class Pair {

	Node<String> current;
	Pair parent;

	public Pair(Node<String> current, Pair curNode) {
		this.current = current;
		this.parent = curNode;
	}

}

//Generic node class
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
