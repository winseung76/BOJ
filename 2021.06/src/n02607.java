import java.io.*;
import java.util.*;

public class n02607 {

	static int[] org = new int[26];
	static int res;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			org[ch - 'A']++;
		}

		for (int i = 0; i < N - 1; i++) {
			String s = br.readLine();
			int[] arr = new int[26];

			for (int j = 0; j < s.length(); j++) {
				char ch = s.charAt(j);
				arr[ch - 'A']++;
			}

			int cnt = 0;
			for (int j = 0; j < 26; j++) {
				if (org[j] != arr[j])
					cnt += Math.abs(org[j] - arr[j]);
			}

			if (s.length() == str.length() && (cnt == 0 || cnt == 2))
				res++;
			else if (cnt == 1)
				res++;

		}

		bw.write(res + "\n");
		bw.flush();

	}

}
