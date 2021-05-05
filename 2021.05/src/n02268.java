import java.io.*;

public class n02268 {

	static int N, M;
	static int[] A;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		A = new int[N + 1];

		SegTree st = new SegTree((N + 1) * 4);

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int a = Integer.parseInt(input[1]);
			int b = Integer.parseInt(input[2]);

			if (n == 0) {
				if (a < b)
					bw.write(st.sum(1, 1, N, a, b) + "\n");
				else
					bw.write(st.sum(1, 1, N, b, a) + "\n");
			}

			else if (n == 1) {
				st.update(1, 1, N, a, b - A[a]);
				A[a] = b;
			}
		}

		bw.flush();

	}

	static class SegTree {

		long[] tree;

		SegTree(int n) {
			tree = new long[n];
		}

		public long sum(int node, int start, int end, int left, int right) {

			if (right < start || end < left)
				return 0;

			if (left <= start && end <= right)
				return tree[node];

			int mid = (start + end) / 2;

			return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
		}

		public void update(int node, int start, int end, int idx, long diff) {

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
