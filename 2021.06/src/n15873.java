import java.io.*;

public class n15873 {

	static int res;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();

		if (str.contains("0")) {
			if (str.indexOf("0") != str.length() - 1) {
				String s1 = str.substring(0, str.indexOf("0") + 1);
				String s2 = str.substring(str.indexOf("0") + 1, str.length());
				res = Integer.parseInt(s1) + Integer.parseInt(s2);
			} else {
				res = (str.charAt(0) - '0') + Integer.parseInt(str.substring(1));
			}

		} else {

			res = (str.charAt(0) - '0') + (str.charAt(1) - '0');
		}

		bw.write(res + "\n");
		bw.flush();

	}

}
