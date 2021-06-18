import java.io.*;

public class n10174 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String str = br.readLine().toLowerCase();

			boolean flag = true;

			for (int j = 0; j < str.length() / 2; j++) {
				if (str.charAt(j) != str.charAt(str.length() - 1 - j)) {
					flag = false;
					break;
				}
			}

			if (flag)
				bw.write("Yes\n");
			else
				bw.write("No\n");
		}

		bw.flush();

	}

}
