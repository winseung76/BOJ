import java.io.*;

public class n13417 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");

			String res = input[0];

			for (int i = 1; i < N; i++) {
				char first = res.charAt(0);
				char ch = input[i].charAt(0);

				if (first < ch)
					res = res + ch;
				else
					res = ch + res;
			}

			bw.write(res + "\n");
		}
		bw.flush();

	}

}
