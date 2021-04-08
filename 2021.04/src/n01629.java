import java.io.*;

public class n01629 {

	static long A, B, C;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");

		A = Long.parseLong(input[0]);
		B = Long.parseLong(input[1]);
		C = Long.parseLong(input[2]);

		bw.write(solve(A, B, C) + "\n");
		bw.flush();

	}

	public static long solve(long a, long b, long c) {

		if (b == 1)
			return a % c;

		long res = solve(a, b / 2, c);

		if (b % 2 == 0)
			return (res * res) % c;
		else
			return (res * solve(a, b / 2 + 1, c)) % c;

	}

}
