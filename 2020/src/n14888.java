import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n14888 {

	static int N;
	static int[] A;
	static int[] op = new int[4];
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		A = new int[N];

		String[] s = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(s[i]);

		s = br.readLine().split(" ");
		for (int i = 0; i < 4; i++)
			op[i] = Integer.parseInt(s[i]);

		dfs(0, A[0], op[0], op[1], op[2], op[3]);

		bw.write(max + "\n");
		bw.write(min + "\n");
		bw.flush();

	}

	public static void dfs(int idx, int n, int p, int mi, int mu, int d) {
		if (idx == N - 1) {
			max = Math.max(max, n);
			min = Math.min(min, n);
			return;
		}
		idx++;
		if (p > 0)
			dfs(idx, n + A[idx], p - 1, mi, mu, d);
		if (mi > 0)
			dfs(idx, n - A[idx], p, mi - 1, mu, d);
		if (mu > 0)
			dfs(idx, n * A[idx], p, mi, mu - 1, d);
		if (d > 0) {
			if (n < 0)
				dfs(idx, -(Math.abs(n) / A[idx]), p, mi, mu, d - 1);
			else
				dfs(idx, n / A[idx], p, mi, mu, d - 1);
		}

	}

	public static void getMax(int idx, int n, int p, int mi, int mu, int d) {

		if (idx == N - 1) {
			max = Math.max(max, n);
			return;
		}

		if (p > 0)
			getMax(idx + 1, n + A[idx + 1], p - 1, mi, mu, d);

		if (mu > 0)
			getMax(idx + 1, n * A[idx + 1], p, mi, mu - 1, d);
		if (p == 0 && mu == 0) {
			if (mi > 0)
				getMax(idx + 1, n - A[idx + 1], p, mi - 1, mu, d);
			if (d > 0) {
				if (n < 0)
					getMax(idx + 1, -(Math.abs(n) / A[idx + 1]), p, mi, mu, d - 1);
				else
					getMax(idx + 1, n / A[idx + 1], p, mi, mu, d - 1);
			}
		}
	}

	public static void getMin(int idx, int n, int p, int mi, int mu, int d) {

		if (idx == N - 1) {

			min = Math.min(min, n);

			return;
		}

		if (mi > 0)
			getMin(idx + 1, n - A[idx + 1], p, mi - 1, mu, d);
		if (d > 0) {
			if (n < 0)
				getMin(idx + 1, -(Math.abs(n) / A[idx + 1]), p, mi, mu, d - 1);
			else
				getMin(idx + 1, n / A[idx + 1], p, mi, mu, d - 1);
		}
		if (mi == 0 && d == 0) {
			if (p > 0)
				getMin(idx + 1, n + A[idx + 1], p - 1, mi, mu, d);
			if (mu > 0)
				getMin(idx + 1, n * A[idx + 1], p, mi, mu - 1, d);
		}
	}

}
