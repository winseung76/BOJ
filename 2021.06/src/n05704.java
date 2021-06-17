import java.io.*;

public class n05704 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = null;

		while (!(str = br.readLine()).equals("*")) {

			boolean[] check = new boolean[26];

			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch != ' ')
					check[(int) (ch - 'a')] = true;
			}

			boolean flag = true;
			for (int i = 0; i < 26; i++) {
				if (!check[i]) {
					flag = false;
					break;
				}
			}

			if (flag)
				bw.write("Y\n");
			else
				bw.write("N\n");
		}
		bw.flush();

	}

}
