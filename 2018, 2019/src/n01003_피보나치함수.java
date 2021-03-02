import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01003_피보나치함수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] zero = new int[41];
		int[] one = new int[41];

		for (int i = 0; i < 41; i++) {
			if (i == 0) {
				zero[i] = 1;
				one[i] = 0;
			} else if (i == 1) {
				zero[i] = 0;
				one[i] = 1;
			} else {
				zero[i] = -1;
				one[i] = -1;
			}
		}
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());

			for (int j = 2; j <= x; j++) {

				zero[j] = zero[j - 1] + zero[j - 2];
				one[j] = one[j - 1] + one[j - 2];

			}
			bw.write(zero[x] + " " + one[x] + "\n");

		}
		bw.flush();

	}
}
