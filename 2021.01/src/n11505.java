import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n11505 {

	static int N, M, K;
	static long[] arr;
	static final int MOD = 1000000007;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		K = Integer.parseInt(s[2]);

		arr = new long[N + 1];

		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(br.readLine());

		Tree tree = new Tree(4 * N);
		tree.init(1, 1, N);

		for (int i = 0; i < M + K; i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			long c = Long.parseLong(s[2]);

			if (a == 1) {
				arr[b] = c;
				tree.update(1, 1, N, b, c);
			}

			else if (a == 2) {
				long res = tree.multi(1, 1, N, b, (int) c);
				bw.write(res + "\n");
			}

		}
		bw.flush();

	}

	static class Tree {

		long[] tree;

		Tree(int n) {
			tree = new long[n];
		}

		public long init(int node, int start, int end) {

			if (start == end)
				return tree[node] = arr[start];

			int mid = (start + end) / 2;

			return tree[node] = (init(node * 2, start, mid) * init(node * 2 + 1, mid + 1, end)) % MOD;

		}

		public long multi(int node, int start, int end, int left, int right) {

			if (left > end || right < start)
				return 1;

			if (left <= start && end <= right)
				return tree[node];

			int mid = (start + end) / 2;

			return (multi(node * 2, start, mid, left, right) * multi(node * 2 + 1, mid + 1, end, left, right)) % MOD;

		}

		public long update(int node, int start, int end, int idx, long n) {

			if (idx > end || idx < start)
				return tree[node];

			if (start == end)
				return tree[node] = n;

			int mid = (start + end) / 2;

			tree[node] = (update(node * 2, start, mid, idx, n) * update(node * 2 + 1, mid + 1, end, idx, n)) % MOD;

			return tree[node];

		}
	}
}
