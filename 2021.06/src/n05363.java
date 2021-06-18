import java.io.*;

public class n05363 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			StringBuilder sb = new StringBuilder();

			for (int j = 2; j < input.length; j++) {
				sb.append(input[j] + " ");
			}

			sb.append(input[0] + " " + input[1] + "\n");

			bw.write(sb.toString());
		}
		bw.flush();

	}

}
