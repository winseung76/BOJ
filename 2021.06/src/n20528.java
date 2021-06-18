import java.io.*;

public class n20528 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		for (int i = 0; i < N - 1; i++) {
			char ch1 = input[i].charAt(input[i].length() - 1);
			char ch2 = input[i + 1].charAt(0);

			if (ch1 != ch2) {
				bw.write(0 + "\n");
				bw.flush();
				return;
			}
		}

		bw.write(1 + "\n");
		bw.flush();

	}

}
