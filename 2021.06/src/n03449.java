import java.io.*;
import java.util.*;

public class n03449 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {

			String str1 = br.readLine();
			String str2 = br.readLine();

			int cnt = 0;

			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) != str2.charAt(i))
					cnt++;
			}
			bw.write("Hamming distance is " + cnt + ".\n");
		}
		bw.flush();

	}

}
