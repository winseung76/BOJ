import java.io.*;

public class n12605 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			String[] input = br.readLine().split(" ");
			String res = "";
			for (int j = input.length - 1; j >= 0; j--) {
				res += input[j] + " ";
			}

			bw.write("Case #" + i + ": " + res + "\n");
		}
		bw.flush();

	}

}
