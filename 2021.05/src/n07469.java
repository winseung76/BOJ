import java.io.*;
import java.util.*;

public class n07469 {

	static int N, M;
	static int[] a;
	static MergeSortTree mst;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		a = new int[N + 1];
		input = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			a[i] = Integer.parseInt(input[i - 1]);
		}

		mst = new MergeSortTree(4 * (N + 1));
		mst.init(1, 1, N);


		for (int m = 0; m < M; m++) {
			input = br.readLine().split(" ");
			int i = Integer.parseInt(input[0]);
			int j = Integer.parseInt(input[1]);
			int k = Integer.parseInt(input[2]);

			int left = -(int) Math.pow(10, 9);
			int right = (int) Math.pow(10, 9);

			int res = binSearch(left, right, i, j, k);
			bw.write(res + "\n");

		}

		bw.flush();

	}

	public static int binSearch(int left, int right, int i, int j, int k) {

		int pl = left;
		int pr = right;

		do {

			int pc = (pl + pr) / 2;

			int res = mst.query(1, 1, N, i, j, pc);

			if (res <= k - 1)
				pl = pc + 1;
			else
				pr = pc - 1;

		} while (pl <= pr);

		return pr;
	}

	static class MergeSortTree {

		List<Integer>[] tree;

		MergeSortTree(int n) {
			tree = new ArrayList[n];
		}

		public List<Integer> init(int node, int start, int end) {

			if (start == end) {
				tree[node] = new ArrayList<>();
				tree[node].add(a[start]);
				return tree[node];
			}

			int mid = (start + end) / 2;

			List<Integer> left = init(node * 2, start, mid);
			List<Integer> right = init(node * 2 + 1, mid + 1, end);

			return tree[node] = merge(left, right);

		}

		public int query(int node, int start, int end, int left, int right, int x) {

			if (right < start || end < left)
				return 0;

			if (left <= start && end <= right)
				return upperBound(tree[node], x);

			int mid = (start + end) / 2;

			return query(node * 2, start, mid, left, right, x) + query(node * 2 + 1, mid + 1, end, left, right, x);

		}

		public int upperBound(List<Integer> node, int x) {

			int pl = 0;
			int pr = node.size() - 1;

			do {
				int pc = (pl + pr) / 2;

				if (node.get(pc) < x)
					pl = pc + 1;
				else
					pr = pc - 1;

			} while (pl <= pr);

			return pr + 1;
		}

		public List<Integer> merge(List<Integer> left, List<Integer> right) {

			if (left == null)
				return right;

			if (right == null)
				return left;

			List<Integer> list = new ArrayList<>();

			int pl = 0, pr = 0;

			while (pl < left.size() && pr < right.size()) {
				list.add((left.get(pl) < right.get(pr)) ? left.get(pl++) : right.get(pr++));
			}

			while (pl < left.size()) {
				list.add(left.get(pl++));
			}

			while (pr < right.size()) {
				list.add(right.get(pr++));
			}

			return list;
		}
	}
}
