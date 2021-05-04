import java.io.*;

public class n02231 {

	static int N;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		solve(0, 0, 0);

		if (min == Integer.MAX_VALUE)
			bw.write(0 + "\n");
		else
			bw.write(min + "\n");
		bw.flush();

	}

	public static void solve(int idx, int n, int sum) {

		if (sum == N) {
			min = Math.min(min, n);
			return;
		}

		if (sum > N || idx > 6)
			return;

		int i = 0;
		if (idx == 0)
			i = 1;

		for (; i <= 9; i++) {
			sum += (Math.pow(10, idx) * i + i);
			n += Math.pow(10, idx) * i;
			solve(idx + 1, n, sum);
			sum -= (Math.pow(10, idx) * i + i);
			n -= Math.pow(10, idx) * i;
		}
	}

}
