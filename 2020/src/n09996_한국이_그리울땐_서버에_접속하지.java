import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n09996_한국이_그리울땐_서버에_접속하지 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		String ptn = br.readLine();
		int pos = ptn.indexOf('*');

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			String substr = ptn.substring(0, pos);
			int idx = str.indexOf(substr);
			if (idx != 0)
				bw.write("NE\n");
			else {
				String substr2 = ptn.substring(pos + 1);
				int idx2 = str.indexOf(substr2, str.length() - substr2.length());
				if (idx2 < 0 || idx2 <= substr.length() - 1)
					bw.write("NE\n");
				else
					bw.write("DA\n");
			}
		}
		bw.flush();
	}
}
