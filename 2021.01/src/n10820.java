import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10820 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str;
		while ((str = br.readLine()) != null) {

			int[] cnt = new int[4];

			for (int j = 0; j < str.length(); j++) {
				char ch = str.charAt(j);

				if (97 <= ch && ch <= 122)
					cnt[0]++;
				else if (65 <= ch && ch <= 90)
					cnt[1]++;
				else if ('0' <= ch && ch <= '9')
					cnt[2]++;
				else if (ch == ' ')
					cnt[3]++;

			}
			bw.write(cnt[0] + " " + cnt[1] + " " + cnt[2] + " " + cnt[3] + "\n");

		}
		bw.flush();
	}

}
