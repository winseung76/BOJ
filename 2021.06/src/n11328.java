import java.io.*;

public class n11328 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			String str1 = input[0];
			String str2 = input[1];
			int[] arr1 = new int[26];
			int[] arr2 = new int[26];

			for (int j = 0; j < str1.length(); j++) {
				char ch = str1.charAt(j);
				arr1[ch - 'a']++;
			}
			for (int j = 0; j < str2.length(); j++) {
				char ch = str2.charAt(j);
				arr2[ch - 'a']++;
			}

			boolean flag = true;
			for (int j = 0; j < 26; j++) {
				if (arr1[j] != arr2[j]) {
					flag = false;
					break;
				}
			}

			if (flag)
				bw.write("Possible\n");
			else
				bw.write("Impossible\n");

		}

		bw.flush();

	}

}
