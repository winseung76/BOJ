import java.io.*;

public class n11382 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long sum = 0;

		String[] input = br.readLine().split(" ");

		for (int i = 0; i < 3; i++) {
			sum += Long.parseLong(input[i]);
		}

		bw.write(sum + "\n");
		bw.flush();

	}

}
