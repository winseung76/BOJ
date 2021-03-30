import java.io.*;

public class n01264 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String comp = "aeiouAEIOU";

		while (true) {

			String str = br.readLine();

			if (str.equals("#"))
				break;

			int cnt = 0;
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);

				if (comp.contains(ch + ""))
					cnt++;
			}
			bw.write(cnt + "\n");
		}
		bw.flush();

	}

}
