import java.io.*;

public class n16673 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");

		int C = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		int P = Integer.parseInt(input[2]);

		int sum = 0;

		for (int i = 1; i <= C; i++) {
			int res = i * K + i * i * P;
			sum += res;
		}

		bw.write(sum + "\n");
		bw.flush();

	}

}
