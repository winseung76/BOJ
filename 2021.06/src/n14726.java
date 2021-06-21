import java.io.*;

public class n14726 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String str = br.readLine();
			int sum = 0;

			for (int i = str.length() - 1; i >= 0; i--) {
				char ch = str.charAt(i);
				int n = ch - '0';

				if (i % 2 != 0)
					sum += n;

				else {

					n *= 2;

					if (n < 10)
						sum += n;
					else {
						String s = String.valueOf(n);
						for (int j = 0; j < s.length(); j++) {
							sum += s.charAt(j) - '0';
						}
					}
				}
			}

			if (sum % 10 == 0)
				bw.write("T\n");
			else
				bw.write("F\n");
		}

		bw.flush();

	}

}
