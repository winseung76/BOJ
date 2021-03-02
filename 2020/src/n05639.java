import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class n05639 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {

		String s;
		BinTree tree = new BinTree();

		while ((s = br.readLine()) != null && s.length() != 0) {

			int n = Integer.parseInt(s);
			tree.add(n);
		}
		tree.print();

	}

	static class Node {
		Node left;
		Node right;
		int data;

		Node(Node left, Node right, int data) {
			this.left = left;
			this.right = right;
			this.data = data;
		}
	}

	static class BinTree {

		Node root;

		public void addNode(Node node, int data) {
			int cond = compare(data, node.data);

			if (cond == 0)
				return;

			if (cond < 0) {
				if (node.left == null)
					node.left = new Node(null, null, data);
				else
					addNode(node.left, data);
			} else {
				if (node.right == null)
					node.right = new Node(null, null, data);
				else
					addNode(node.right, data);
			}
		}

		public void add(int data) {

			if (root == null)
				root = new Node(null, null, data);
			else
				addNode(root, data);

		}

		public int compare(int a, int b) {
			return a - b;
		}

		public void postOrder(Node node) {
			if (node != null) {
				postOrder(node.left);
				postOrder(node.right);
				System.out.println(node.data);
			}
		}

		public void print() {
			postOrder(root);
		}
	}
}
