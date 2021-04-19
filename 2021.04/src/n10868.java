import java.io.*;

public class n10868 {

	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		SegTree segTree = new SegTree(4 * N);
		segTree.init(1, 1, N);

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);

			int res = segTree.getMin(1, 1, N, a, b);
			bw.write(res + "\n");
		}
		bw.flush();

	}

	static class SegTree {

		int[] tree;

		SegTree(int n) {
			tree = new int[n];
		}

		public int init(int node, int start, int end) {

			if (start == end)
				return tree[node] = arr[start];

			int mid = (start + end) / 2;

			tree[node] = Math.min(init(node * 2, start, mid), init(node * 2 + 1, mid + 1, end));

			return tree[node];
		}

		public int getMin(int node, int start, int end, int left, int right) {

			if (left > end || right < start)
				return Integer.MAX_VALUE;

			if (left <= start && end <= right)
				return tree[node];

			int mid = (start + end) / 2;

			return Math.min(getMin(node * 2, start, mid, left, right), getMin(node * 2 + 1, mid + 1, end, left, right));
		}

	}

}
