import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n11816 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String X = br.readLine();
		int n = 0;
		int m = 10;

		if (X.startsWith("0x")) {
			X = X.substring(2);
			m = 16;
		}

		else if (X.startsWith("0")) {
			X = X.substring(1);
			m = 8;
		}

		int k = 0;
		for (int i = X.length() - 1; i >= 0; i--) {
			char ch = X.charAt(i);

			if ('0' <= ch && ch <= '9')
				n += (ch - '0') * Math.pow(m, k++);
			else
				n += (ch - 87) * Math.pow(m, k++);
		}

		bw.write(n + "\n");
		bw.flush();

	}

}
