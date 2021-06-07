import java.io.*;

public class n05361 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int c = Integer.parseInt(input[2]);
			int d = Integer.parseInt(input[3]);
			int e = Integer.parseInt(input[4]);

			double res = a * 350.34 + b * 230.90 + c * 190.55 + d * 125.30 + e * 180.90;

			bw.write("$"+String.format("%.2f", res) + "\n");
		}
		bw.flush();

	}

}
