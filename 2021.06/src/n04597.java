import java.io.*;

public class n04597 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = "";

		while (!(str = br.readLine()).equals("#")) {

			int zero = 0;
			int one = 0;

			for (int i = 0; i < str.length() - 1; i++) {
				char ch = str.charAt(i);
				if (ch == '0')
					zero++;
				else if (ch == '1')
					one++;
			}

			char ch = str.charAt(str.length() - 1);

			if (ch == 'e') {
				if (one % 2 == 0)
					str = str.replace('e', '0');
				else
					str = str.replace('e', '1');
			}

			else if (ch == 'o') {
				if (one % 2 == 0)
					str = str.replace('o', '1');
				else
					str = str.replace('o', '0');
			}

			bw.write(str + "\n");
		}
		bw.flush();

	}

}
