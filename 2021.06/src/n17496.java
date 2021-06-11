import java.io.*;
import java.util.*;

public class n17496 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int T = Integer.parseInt(input[1]);
		int C = Integer.parseInt(input[2]);
		int P = Integer.parseInt(input[3]);

		int cnt = 0;
		int date = 1 + T;
		while (date <= N) {
			cnt++;
			date += T;
		}

		bw.write(cnt * C * P + "\n");
		bw.flush();

	}

}
