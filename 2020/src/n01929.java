import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01929 {

	static int[] prime;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		int M = Integer.parseInt(s[0]);
		int N = Integer.parseInt(s[1]);

		prime = new int[N + 1];

		int idx = 0;

		prime[idx++] = 2;
		prime[idx++] = 3;

		boolean flag;
		for (int n = 5; n <= N; n++) {
			flag = false;
			for (int i = 0; prime[i] * prime[i] <= n; i++) {
				if (n % prime[i] == 0) {
					flag = true;
					break;
				}
			}
			if (!flag)
				prime[idx++] = n;
		}
		for (int i = 0; i < idx; i++) {
			if (M <= prime[i] && prime[i] <= N) {
				bw.write(prime[i] + "\n");
			}
		}
		bw.flush();

	}

}
