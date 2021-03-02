import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01929 {

	static boolean[] prime;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		int M = Integer.parseInt(s[0]);
		int N = Integer.parseInt(s[1]);

		prime = new boolean[N + 1];

		for (int i = 2; i <= N; i++)
			prime[i] = true;

		for (int n = 2; n * n <= N; n++) {
			if (prime[n]) {
				for (int i = 2; n * i <= N; i++) {
					prime[n * i] = false;
				}
			}
		}

		for (int i = M; i <= N; i++) {
			if (prime[i])
				bw.write(i + "\n");
		}
		bw.flush();

	}

}
