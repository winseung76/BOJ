import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01225 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");

		String A = sarr[0];
		String B = sarr[1];

		long sum = 0;

		for (int i = 0; i < A.length(); i++) {
			int a = A.charAt(i) - '0';
			for (int j = 0; j < B.length(); j++) {
				int b = B.charAt(j) - '0';

				sum += a * b;

			}
		}

		bw.write(sum + "\n");
		bw.flush();

	}

}
