import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02576 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int sum = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < 7; i++) {
			int n = Integer.parseInt(br.readLine());

			if (n % 2 == 1) {
				sum += n;
				min = Math.min(min, n);
			}

		}
		if (sum == 0)
			bw.write(-1 + "\n");
		else {
			bw.write(sum + "\n");
			bw.write(min + "\n");
		}
		bw.flush();

	}

}
