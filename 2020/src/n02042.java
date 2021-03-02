import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02042 {

	static int N, M, K;
	static long[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		K = Integer.parseInt(s[2]);

		arr = new long[N + 1];
		for (int i = 1; i <= N; i++) 
			arr[i] = Long.parseLong(br.readLine());
		

		SegTree tree = new SegTree(4 * N);
		
		tree.init(1, 1, N);

		for (int i = 0; i < M + K; i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			long c = Long.parseLong(s[2]);

			if (a == 1) {
				tree.update(1, b, c - arr[b], 1, N);
				arr[b]=c;
			}
			else if (a == 2)
				bw.write(tree.sum(1, 1, N, b, (int) c) + "\n");
		}

		bw.flush();

	}

	static class SegTree {

		long[] tree;

		SegTree(int n) {
			tree = new long[n];
		}

		public long init(int node, int start, int end) {

			if (start == end)
				return tree[node] = arr[start];

			int mid = (start + end) / 2;

			tree[node] = init(node * 2, start, mid) 
					     + init(node * 2 + 1, mid + 1, end);

			return tree[node];
		}

		public long sum(int node, int start, int end, int left, int right) {

			if (left > end || right < start)
				return 0;

			if (left <= start && end <= right)
				return tree[node];

			int mid = (start + end) / 2;

			return sum(node * 2, start, mid, left, right) 
					+ sum(node * 2 + 1, mid + 1, end, left, right);

		}

		public void update(int node, int idx, long diff, int start, int end) {

			if (idx < start || end < idx)
				return;

			tree[node] += diff;

			if (start == end)
				return;

			int mid = (start + end) / 2;

			update(node * 2, idx, diff, start, mid);
			update(node * 2 + 1, idx, diff, mid + 1, end);
		}
	}

}
