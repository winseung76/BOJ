import java.io.*;
import java.util.*;

public class n10610 {

	static String str;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		str = br.readLine();

		String[] arr = str.split("");
		Arrays.sort(arr, Collections.reverseOrder());

		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			buf.append(arr[i]);
		}

		String res = buf.toString();

		int sum = 0;
		for (int i = 0; i < res.length(); i++) {
			sum += res.charAt(i) - '0';
		}

		if (res.contains("0") && sum % 3 == 0)
			bw.write(res + "\n");
		else
			bw.write(-1 + "\n");

		bw.flush();
	}
}
