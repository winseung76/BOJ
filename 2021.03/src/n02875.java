import java.io.*;

public class n02875 {

	static int N, M, K;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);
		K = Integer.parseInt(sarr[2]);

		int n = N;
		int m = M;
		int cnt = 0;
		while (n >= 2 && m >= 1) {

			if ((n - 2) + (m - 1) < K)
				break;

			n = n - 2;
			m = m - 1;
			cnt++;
		}

		bw.write(cnt + "\n");
		bw.flush();

	}
}
