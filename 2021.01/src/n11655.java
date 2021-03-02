import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n11655 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (65 <= ch && ch <= 90) {
				ch = (char) (ch + 13);
				if (ch > 90)
					ch = (char) (ch - 26);
			} else if (97 <= ch && ch <= 122) {
				ch = (char) (ch + 13);
				if (ch > 122)
					ch = (char) (ch - 26);
			}
			bw.write(ch);

		}
		bw.flush();

	}

}
