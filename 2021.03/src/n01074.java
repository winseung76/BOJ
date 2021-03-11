import java.io.*;

public class n01074 {

	static int N, r, c;
	static int size;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		r = Integer.parseInt(sarr[1]);
		c = Integer.parseInt(sarr[2]);

		size = (int) Math.pow(2, N);

		int res = solve(0, 0, size);

		bw.write(res + "\n");
		bw.flush();

	}

	public static int solve(int nr, int nc, int size) {

		if (size == 1) {
			return 0;
		}

		if (r < nr + size / 2 && c < nc + size / 2)
			return solve(nr, nc, size / 2);

		else if (r < nr + size / 2 && c < nc + size)
			return solve(nr, nc + size / 2, size / 2) + (int) Math.pow(size / 2, 2);

		else if (r < nr + size && c < nc + size / 2)
			return solve(nr + size / 2, nc, size / 2) + (int) Math.pow(size / 2, 2) * 2;

		else
			return solve(nr + size / 2, nc + size / 2, size / 2) + (int) Math.pow(size / 2, 2) * 3;

	}
}
