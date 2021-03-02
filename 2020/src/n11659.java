import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n11659 {

	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		arr = new int[N + 1];

		s = br.readLine().split(" ");
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(s[i - 1]);

		Tree tree = new Tree(4 * N);
		tree.init(1, 1, N);

		for (int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			int start = Integer.parseInt(s[0]);
			int end = Integer.parseInt(s[1]);
			bw.write(tree.sum(1, 1, N, start, end) + "\n");
		}
		bw.flush();

	}

	static class Tree {
		int[] tree;

		Tree(int n) {
			tree = new int[n];
		}

		public int init(int node, int start, int end) {

			if (start == end)
				return tree[node] = arr[start];

			int mid = (start + end) / 2;

			return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
		}

		public int sum(int node, int start, int end, int left, int right) {

			if (left > end || right < start)
				return 0;

			if (left <= start && end <= right)
				return tree[node];

			int mid = (start + end) / 2;

			return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
		}
	}

}
