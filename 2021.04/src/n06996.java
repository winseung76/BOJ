import java.io.*;
import java.util.Arrays;

public class n06996 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String[] input = br.readLine().split(" ");
			char[] arr1 = input[0].toCharArray();
			char[] arr2 = input[1].toCharArray();

			Arrays.sort(arr1);
			Arrays.sort(arr2);

			StringBuilder sb1 = new StringBuilder();
			for (int i = 0; i < arr1.length; i++) {
				sb1.append(arr1[i]);
			}

			StringBuilder sb2 = new StringBuilder();
			for (int i = 0; i < arr2.length; i++) {
				sb2.append(arr2[i]);
			}

			if (sb1.toString().equals(sb2.toString()))
				bw.write(input[0] + " & " + input[1] + " are anagrams.\n");
			else
				bw.write(input[0] + " & " + input[1] + " are NOT anagrams.\n");
		}

		bw.flush();

	}

}
