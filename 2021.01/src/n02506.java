import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02506 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String[] sarr = br.readLine().split(" ");
		int sum = 0;
		int g = 0;
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(sarr[i]);

			if (n == 1) {
				if (i == 0 || Integer.parseInt(sarr[i - 1]) == 0) {
					g = 1;
					sum += g;
				} else
					sum += ++g;
			}
		}
		bw.write(sum + "\n");
		bw.flush();

	}

}
