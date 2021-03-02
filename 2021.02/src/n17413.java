import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n17413 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String S = br.readLine();
		boolean[] chg = new boolean[S.length()];

		int start = -1;
		int end = -1;
		int pos = 0;
		while (pos < S.length()) {
			start = S.indexOf("<", pos++);
			end = S.indexOf(">", pos++);

			if (start >= 0 && end >= 0) {
				for (int i = start; i <= end; i++)
					chg[i] = true;
			}
		}

		pos = 0;
		while (pos < S.length()) {

			if (chg[pos])
				bw.write(S.charAt(pos++));
			else {
				start = pos;
				end = pos;
				while (end < S.length() && !chg[end++])
					;

				if (end < S.length())
					end--;

				String str = S.substring(start, end);
				String[] sarr = str.split(" ");

				for (int i = 0; i < sarr.length; i++) {

					for (int j = sarr[i].length() - 1; j >= 0; j--)
						bw.write(sarr[i].charAt(j));

					if (i < sarr.length - 1)
						bw.write(" ");
				}
				pos = end;
			}

		}

		bw.flush();

	}

}
