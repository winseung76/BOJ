import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n03058 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String[] sarr = br.readLine().split(" ");
			int sum = 0;
			int min = Integer.MAX_VALUE;

			for (int j = 0; j < 7; j++) {
				int n = Integer.parseInt(sarr[j]);
				if (n % 2 == 0) {
					sum += n;
					min = Math.min(min, n);
				}
			}
			bw.write(sum + " " + min + "\n");
		}
		bw.flush();

	}

}
