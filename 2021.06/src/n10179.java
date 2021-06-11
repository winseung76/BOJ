import java.io.*;
import java.util.*;

public class n10179 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			double d = Double.parseDouble(br.readLine());
			double res = d * 0.8;

			bw.write("$" + String.format("%.2f", res) + "\n");
		}
		bw.flush();

	}

}
