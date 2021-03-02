import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;


public class n01967_트리의_지름 {
	static Vector<Node>[] vector;
	static boolean[] isvisited;
	static int n;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());

		vector = new Vector[n + 1];
		for (int i = 1; i <= n; i++)
			vector[i] = new Vector<>();

		for (int i = 0; i < n - 1; i++) {
			String[] arr = br.readLine().split(" ");
			int A = Integer.parseInt(arr[0]);
			int B = Integer.parseInt(arr[1]);
			int W = Integer.parseInt(arr[2]);

			vector[A].add(new Node(B, W));
			vector[B].add(new Node(A, W));
		}

		isvisited = new boolean[n + 1];
		int maxDistNode = getTreeDiameter(1).n;

		isvisited = new boolean[n + 1];
		int res = getTreeDiameter(maxDistNode).weight;

		bw.write(res + "\n");
		bw.flush();

	}

	static Node getTreeDiameter(int s) {

		int max = 0;
		int n = 0;
		Queue<Node> q = new LinkedList<>();

		q.add(new Node(s, 0));
		isvisited[s] = true;

		while (!q.isEmpty()) {

			Node p = q.poll();

			for (int i = 0; i < vector[p.n].size(); i++) {
				Node node = vector[p.n].get(i);

				if (!isvisited[node.n]) {
					int nw = p.weight + node.weight;

					q.add(new Node(node.n, nw));
					if (max < nw) {
						max = nw;
						n = node.n;
					}
					isvisited[node.n] = true;
				}
			}
		}
		return new Node(n, max);

	}

	static class Node {
		int n, weight;

		Node(int n, int weight) {
			this.n = n;
			this.weight = weight;
		}
	}
}
