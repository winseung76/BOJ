import java.io.*;

public class n13163 {

	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			input[0] = "god";

			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < input.length; j++) {
				sb.append(input[j]);
			}

			bw.write(sb.toString() + "\n");
		}
		bw.flush();

	}

}
