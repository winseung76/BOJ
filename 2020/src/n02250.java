import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02250 {

	static Node[] arr = new Node[10001];
	static int[] depth = new int[10001];
	static int[] col = new int[10001];
	static int idx = 1;
	static int root;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int maxLevel = 0;

		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");

			int p = Integer.parseInt(s[0]);
			int l = Integer.parseInt(s[1]);
			int r = Integer.parseInt(s[2]);

			if (arr[p] == null)
				arr[p] = new Node(p, -1, l, r);
			else {
				arr[p].left = l;
				arr[p].right = r;
			}

			if (l > 0) {
				if (arr[l] == null)
					arr[l] = new Node(l, p, -1, -1);
				else
					arr[l].parent = p;
			}
			if (r > 0) {
				if (arr[r] == null)
					arr[r] = new Node(r, p, -1, -1);
				else
					arr[r].parent = p;
			}

		}

		for (int i = 1; i <= N; i++) {
			if (arr[i].parent == -1) {
				root = i;
				break;
			}
		}

		depth[root] = 1;
		getDepth(root);

		for (int i = 1; i <= N; i++)
			maxLevel = Math.max(maxLevel, depth[i]);

		inOrder(arr[root]);

		int level = 1, width = 0;

		for (int dep = 1; dep <= maxLevel; dep++) {

			int min = 0, max = 0;

			for (int j = N; j >= 1; j--) {
				if (col[j] == dep) {
					max = j;
					break;
				}
			}

			for (int j = 1; j <= N; j++) {
				if (col[j] == dep) {
					min = j;
					break;
				}
			}

			int diff = max - min + 1;
			if (width < diff) {
				level = dep;
				width = diff;
			}
		}

		bw.write(level + " " + width);
		bw.flush();

	}

	public static void getDepth(int parent) {

		int lc = arr[parent].left;
		int rc = arr[parent].right;

		if (lc != -1) {
			depth[lc] = depth[parent] + 1;
			getDepth(lc);
		}
		if (rc != -1) {
			depth[rc] = depth[parent] + 1;
			getDepth(rc);
		}
	}

	public static void inOrder(Node node) {

		int left = node.left;
		int right = node.right;

		if (left > 0)
			inOrder(arr[left]);

		col[idx++] = depth[node.n];

		if (right > 0)
			inOrder(arr[right]);
	}

	static class Node {
		int n;
		int parent;
		int left, right;

		Node(int n, int parent, int left, int right) {
			this.n = n;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}
	}
}
