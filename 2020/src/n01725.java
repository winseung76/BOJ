import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01725 {

	static int N;
	static int[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];

		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(br.readLine());

		Tree tree = new Tree(4 * N);
		tree.init(1, 1, N);

		bw.write(tree.getMaxArea(1, N) + "\n");
		bw.flush();

	}

	static class Tree {
		int[] tree;

		Tree(int n) {
			tree = new int[n];
		}

		public int init(int node, int start, int end) {

			if (start == end)
				return tree[node] = start;

			int mid = (start + end) / 2;

			int idx1 = init(node * 2, start, mid);
			int idx2 = init(node * 2 + 1, mid + 1, end);

			if (arr[idx1] < arr[idx2])
				return tree[node] = idx1;
			else
				return tree[node] = idx2;
		}

		public int query(int node, int start, int end, int left, int right) {

			if (left > end || right < start)
				return -1;

			if (left <= start && end <= right)
				return tree[node];

			int mid = (start + end) / 2;

			int idx1 = query(node * 2, start, mid, left, right);
			int idx2 = query(node * 2 + 1, mid + 1, end, left, right);

			if (idx1 == -1)
				return idx2;
			else if (idx2 == -1)
				return idx1;
			else {
				if (arr[idx1] < arr[idx2])
					return idx1;
				else
					return idx2;
			}

		}

		public long getMaxArea(int left, int right) {

			long area1 = 0, area2 = 0;
			int idx = query(1, 1, N, left, right);

			long area = (right - left + 1) * arr[idx];

			if (left <= idx - 1)
				area1 = getMaxArea(left, idx - 1);
			if (idx + 1 <= right)
				area2 = getMaxArea(idx + 1, right);

			return Math.max(area, Math.max(area1, area2));
		}
	}

}
