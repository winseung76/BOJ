import java.io.*;

public class n11024 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			int sum = 0;
			for (int j = 0; j < input.length; j++) {
				sum += Integer.parseInt(input[j]);
			}
			bw.write(sum + "\n");
		}
		bw.flush();

	}

}
