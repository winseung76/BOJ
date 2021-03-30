import java.io.*;

public class n14490 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(":");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		int n = N;
		int m = M;
		while (n != m) {

			if (n > m)
				n -= m;
			else
				m -= n;
		}

		bw.write((N / m) + ":" + (M / m));
		bw.flush();

	}

}
