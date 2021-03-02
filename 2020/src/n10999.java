import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10999 {

	static int N, M, K;
	static int[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		K = Integer.parseInt(s[2]);

		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Tree tree = new Tree(4 * N);
		tree.init(1, 1, N);

		for (int i = 0; i < M + K; i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);

			if (a == 1) {
				int b = Integer.parseInt(s[1]);
				int c = Integer.parseInt(s[2]);
				int d = Integer.parseInt(s[3]);
				tree.update(1, d, 1, N, b, c);

			} else if (a == 2) {
				int b = Integer.parseInt(s[1]);
				int c = Integer.parseInt(s[2]);
				bw.write(tree.sum(1, 1, N, b, c) + "\n");
			}
		}
		bw.flush();

	}

	static class Tree {
		long[] tree;

		Tree(int n) {
			tree = new long[n];
		}

		public long init(int node, long start, long end) {

			if (start == end)
				return tree[node] = arr[(int) start];

			long mid = (start + end) / 2;

			return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);

		}

		public long sum(int node, long start, long end, long left, long right) {

			if (left > end || right < start)
				return 0;

			if (left <= start && end <= right)
				return tree[node];

			long mid = (start + end) / 2;

			return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
		}

		public long update(int node, long n, long start, long end, long left, long right) {

			if (left > end || right < start)
				return tree[node];

			if (start == end) {
				if (left <= start && start <= right)
					tree[node] += n;
				return tree[node];
			}

			long mid = (start + end) / 2;

			tree[node] = update(node * 2, n, start, mid, left, right)
					+ update(node * 2 + 1, n, mid + 1, end, left, right);

			return tree[node];

		}
	}
}
