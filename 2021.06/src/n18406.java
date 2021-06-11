import java.io.*;

public class n18406 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();

		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < str.length() / 2; i++) {
			sum1 += str.charAt(i) - '0';
		}

		for (int i = str.length() / 2; i < str.length(); i++) {
			sum2 += str.charAt(i) - '0';
		}

		if (sum1 == sum2)
			bw.write("LUCKY");
		else
			bw.write("READY");

		bw.flush();

	}

}
