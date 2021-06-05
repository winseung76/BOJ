import java.io.*;

public class n10156 {

	static int K, N, M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		K = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);
		M = Integer.parseInt(input[2]);

		if (K * N > M)
			bw.write((K * N - M) + "\n");
		else
			bw.write(0 + "\n");

		bw.flush();

	}

}
