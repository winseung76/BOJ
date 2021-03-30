import java.io.*;

public class n03059 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			boolean[] alphabet = new boolean[26];

			for (int j = 0; j < str.length(); j++) {
				char ch = str.charAt(j);

				alphabet[ch - 'A'] = true;
			}
			int sum = 0;
			for (int j = 0; j < 26; j++) {
				if (!alphabet[j]) {
					sum += j + 'A';
				}
			}

			bw.write(sum + "\n");
		}
		bw.flush();

	}

}
