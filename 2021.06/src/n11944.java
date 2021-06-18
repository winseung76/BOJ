import java.io.*;

public class n11944 {

	static int N, M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(N);

			if (sb.length() >= M) {
				String res = sb.substring(0, M);
				bw.write(res + "\n");
				bw.flush();
				return;
			}
		}

		bw.write(sb.toString() + "\n");
		bw.flush();
	}

}
