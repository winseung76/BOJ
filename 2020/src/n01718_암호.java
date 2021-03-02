import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01718_¾ÏÈ£ {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String plain = br.readLine();
		String ek = br.readLine();

		for (int i = 0; i < plain.length(); i++) {
			char ch = plain.charAt(i);

			if (ch == ' ')
				bw.write(" ");
			else {
				int idx = i % ek.length();

				char ch2 = (char) (ch - (ek.charAt(idx) - 'a' + 1));
				if (ch2 < 'a')
					ch2 = (char) ('z' - ('a' - ch2) + 1);

				bw.write(ch2);
			}
		}
		bw.flush();
	}
}
