import java.io.*;

public class n11575 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);

			String str = br.readLine();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				int res = (a * (ch - 65) + b) % 26;
				char nch = (char) (res + 65);
				sb.append(nch);
			}

			bw.write(sb.toString() + "\n");
		}
		bw.flush();

	}

}
