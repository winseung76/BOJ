import java.io.*;

public class n01405 {

	static boolean[][] visited = new boolean[30][30];
	static int N;
	static double[] prob = new double[4];
	static double check;
	static int[] r = { 0, 0, 1, -1 };
	static int[] c = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		for (int i = 0; i < 4; i++)
			prob[i] = Double.parseDouble(input[i + 1]) / 100.0;

		visited[15][15] = true;
		solve(15, 15, 1.0, 0);

		bw.write(check + "\n");
		bw.flush();

	}

	public static void solve(int nr, int nc, double mul, int move) {

		if (move == N) {

			check += mul;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int mr = nr + r[i];
			int mc = nc + c[i];

			if (!visited[mr][mc] && prob[i] > 0) {
				visited[mr][mc] = true;
				solve(mr, mc, mul * prob[i], move + 1);
				visited[mr][mc] = false;
			}

		}

	}
}
