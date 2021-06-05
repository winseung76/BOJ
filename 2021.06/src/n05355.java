import java.io.*;
import java.util.*;

public class n05355 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String[] input = br.readLine().split(" ");
			double d = Double.parseDouble(input[0]);
			double res = d;

			for (int i = 1; i < input.length; i++) {
				String op = input[i];

				switch (op) {
				case "@":
					res *= 3;
					break;
				case "%":
					res += 5;
					break;
				case "#":
					res -= 7;
					break;
				default:
					break;
				}
			}

			bw.write(String.format("%.2f", res) + "\n");
		}
		bw.flush();

	}

}
