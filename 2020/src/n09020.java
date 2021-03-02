import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n09020 {

	static boolean[] prime = new boolean[10000];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		prime[2] = true;
		prime[3] = true;
		boolean flag;
		int i, j;
		for (i = 5; i < 10000; i += 2) {
			flag = false;
			for (j = 2; j < i; j++) {
				if (i % j == 0) {
					flag = true;
					break;
				}
			}
			if (!flag)
				prime[j] = true;
		}

		for (i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			int a=0, b=0;

			for (j = 2; j <= n / 2; j++) {
				if (prime[j] && prime[n - j]) {
					a = j;
					b = n - j;
				}
			}
			bw.write(a + " " + b + "\n");

		}
		bw.flush();

	}

}
