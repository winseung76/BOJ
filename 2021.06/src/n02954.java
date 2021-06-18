import java.io.*;

public class n02954 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();

		StringBuilder sb = new StringBuilder();

		int idx = 0;
		while (idx < str.length()) {
			char ch = str.charAt(idx);

			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				String sub = str.substring(idx, idx + 3);
				if (sub.equals(ch + "p" + ch)) {
					idx += 3;
				}

				else {
					idx++;
				}
			}

			else {
				idx++;
			}

			sb.append(ch);
		}

		bw.write(sb.toString() + "\n");
		bw.flush();

	}

}
