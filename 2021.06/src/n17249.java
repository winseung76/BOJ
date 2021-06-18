import java.io.*;

public class n17249 {

	static int lcnt, rcnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		int center = str.indexOf('0');

		int idx = 0;
		while (idx < str.length()) {
			int pos = str.indexOf("@", idx);
			if (pos != -1) {
				idx = pos + 1;
				if (pos < center)
					lcnt++;
				else
					rcnt++;
			}

			else
				idx++;
		}

		bw.write(lcnt + " " + rcnt + "\n");
		bw.flush();

	}

}
