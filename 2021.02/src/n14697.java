import java.io.*;

public class n14697 {

	static int N;
	static int[] room = new int[3];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		for (int i = 0; i < 3; i++)
			room[i] = Integer.parseInt(sarr[i]);
		N = Integer.parseInt(sarr[3]);

		boolean res = solve(0, N);

		if (res)
			bw.write(1 + "\n");
		else
			bw.write(0 + "\n");

		bw.flush();

	}

	public static boolean solve(int idx, int n) {

		if (idx == 3 && n > 0)
			return false;

		if (n == 0)
			return true;

		for (int i = n / room[idx]; i >= 0; i--) {
			if (solve(idx + 1, n - i * room[idx]))
				return true;
		}

		return false;

	}

}
