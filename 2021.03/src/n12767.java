import java.io.*;
import java.util.*;

public class n12767 {

	static HashSet<String> set = new HashSet<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);

		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			BST bst = new BST();
			for (int j = 0; j < k; j++) {
				bst.insertBST(Integer.parseInt(input[j]));
			}
			bst.inorderBST();
		}

		bw.write(set.size() + "\n");
		bw.flush();

	}

	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode() {
			this.left = null;
			this.right = null;
		}

		public TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		public int getData() {
			return data;
		}
	}

	public static class BST {
		private TreeNode root = new TreeNode();

		public TreeNode insertKey(TreeNode root, int x) {
			TreeNode p = root;
			TreeNode newNode = new TreeNode(x);

			if (p == null) {
				return newNode;
			} else if (p.data > newNode.data) {
				p.left = insertKey(p.left, x);
				return p;
			} else if (p.data < newNode.data) {
				p.right = insertKey(p.right, x);
				return p;
			} else {
				return p;
			}
		}

		public void insertBST(int x) {
			root = insertKey(root, x);
		}

		public TreeNode searchBST(int x) {
			TreeNode p = root;
			while (p != null) {
				if (x < p.data)
					p = p.left;
				else if (x > p.data)
					p = p.right;
				else
					return p;
			}
			return p;
		}

		public void inorder(TreeNode root, String s, StringBuffer buf) {

			buf.append(s);

			if (root != null) {
				inorder(root.left, "L", buf);
				inorder(root.right, "R", buf);
			}
		}

		public void inorderBST() {
			StringBuffer buf = new StringBuffer();
			inorder(root, "", buf);
			set.add(buf.toString());

		}
	}

}
