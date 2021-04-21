import java.io.*;

public class n03653 {

	static int T;
	static int n, m;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String[] input = br.readLine().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);

			int[] index = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				index[i] = i + m - 1;
			}

			SegTree st = new SegTree(4 * (n + m));
			st.init(1, 0, n + m - 1);

			input = br.readLine().split(" ");

			for (int i = 0; i < m; i++) {
				int movie = Integer.parseInt(input[i]);
				int idx = index[movie];
				bw.write(st.sum(1, 0, n + m - 1, 0, idx - 1) + " ");

				st.update(1, 0, n + m - 1, idx, -1);
				st.update(1, 0, n + m - 1, m - 1 - i, 1);
				index[movie] = m - 1 - i;
			}
			bw.write("\n");

		}
		bw.flush();

	}

	static class SegTree {

		int[] tree;

		SegTree(int n) {
			tree = new int[n];
		}

		public int init(int node, int start, int end) {

			if (start == end) {
				if (start < m)
					return tree[node] = 0;
				else
					return tree[node] = 1;
			}

			int mid = (start + end) / 2;

			tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);

			return tree[node];
		}

		public int sum(int node, int start, int end, int left, int right) {

			if (right < start || end < left)
				return 0;

			if (left <= start && end <= right)
				return tree[node];

			int mid = (start + end) / 2;

			return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
		}

		public void update(int node, int start, int end, int idx, int diff) {

			if (idx < start || end < idx)
				return;

			tree[node] += diff;

			if (start == end)
				return;

			int mid = (start + end) / 2;

			update(node * 2, start, mid, idx, diff);
			update(node * 2 + 1, mid + 1, end, idx, diff);
		}

	}

}
