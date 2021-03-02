import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01747 {

	static int N;
	static boolean[] prime;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		prime = new boolean[10 * N];

		for (int i = 2; i < prime.length; i++)
			prime[i] = true;

		for (int n = 2; n * n < prime.length; n++) {
			if (prime[n]) {
				for (int i = 2; n * i < prime.length; i++) {
					prime[n * i] = false;
				}
			}
		}

		for (int i = N; i < prime.length; i++) {
			if (prime[i]) {
				String s = String.valueOf(i);
				boolean flag = true;
				for (int j = 0; j < s.length() / 2; j++) {
					if (s.charAt(j) != s.charAt(s.length() - j - 1)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					bw.write(i + "\n");
					break;
				}
			}
		}
		bw.flush();

	}

}
