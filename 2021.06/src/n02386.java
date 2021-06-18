import java.io.*;

public class n02386 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {

			String[] input = br.readLine().split(" ");
			String alpha = input[0];

			if (alpha.equals("#"))
				break;

			alpha.toLowerCase();

			int cnt = 0;

			for (int k = 1; k < input.length; k++) {
				String str = input[k];
				str = str.toLowerCase();

				for (int i = 0; i < str.length(); i++) {
					char ch = str.charAt(i);

					if (ch == alpha.charAt(0)) {
						cnt++;
					}
				}
			}

			bw.write(alpha + " " + cnt + "\n");
		}

		bw.flush();

	}

}
