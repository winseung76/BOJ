import java.io.*;

public class n15658 {

	static int N;
	static int[] A;
	static int[] op = new int[4];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		A = new int[N];
		String[] sarr = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(sarr[i]);
		}
		sarr = br.readLine().split(" ");
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(sarr[i]);
		}

		solve(A[0], 1);

		bw.write(max + "\n");
		bw.write(min + "\n");
		bw.flush();

	}

	public static void solve(int sum, int idx) {

		if (idx == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (op[i] > 0) {
				op[i]--;
				if (i == 0)
					solve(sum + A[idx], idx + 1);
				if (i == 1)
					solve(sum - A[idx], idx + 1);
				if (i == 2)
					solve(sum * A[idx], idx + 1);
				if (i == 3)
					solve(sum / A[idx], idx + 1);
				op[i]++;
			}
		}
	}

}
