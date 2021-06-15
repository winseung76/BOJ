import java.io.*;

public class n11134 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int C = Integer.parseInt(input[1]);

			int res = N % C == 0 ? N / C : N / C + 1;
			bw.write(res + "\n");
		}
		bw.flush();

	}

}
