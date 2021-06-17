import java.io.*;

public class n05789 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			if (str.charAt(str.length() / 2 - 1) == str.charAt(str.length() / 2))
				bw.write("Do-it\n");
			else
				bw.write("Do-it-Not\n");
		}
		bw.flush();

	}

}
