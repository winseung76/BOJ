import java.io.*;
import java.util.*;

public class n03062 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String str = br.readLine();
			StringBuffer buf = new StringBuffer(str);

			int n = Integer.parseInt(str) + Integer.parseInt(buf.reverse().toString());

			String tmp = String.valueOf(n);

			boolean flag = true;

			for (int i = 0; i < tmp.length() / 2 + 1; i++) {
				if (tmp.charAt(i) != tmp.charAt(tmp.length() - i - 1)) {
					flag = false;
					break;
				}
			}

			if (flag)
				bw.write("YES\n");
			else
				bw.write("NO\n");

		}
		bw.flush();
	}

}
