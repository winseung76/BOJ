import java.io.*;

public class n03028 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		int pos = 1;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch == 'A') {

				if (pos == 1)
					pos = 2;
				else if (pos == 2)
					pos = 1;
			}

			if (ch == 'B') {
				if (pos == 2)
					pos = 3;
				else if (pos == 3)
					pos = 2;
			}

			if (ch == 'C') {
				if (pos == 1)
					pos = 3;
				else if (pos == 3)
					pos = 1;
			}

		}

		bw.write(pos + "\n");
		bw.flush();

	}

}
