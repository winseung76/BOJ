import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n06588 {

	static boolean[] prime = new boolean[1000001];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < prime.length; i++)
			prime[i] = true;

		for (int i = 2; i * i <= 1000000; i++) {
			if (prime[i]) {
				for (int j = 2; i * j <= 1000000; j++) {
					prime[i * j] = false;
				}
			}
		}

		while (true) {

			int n = Integer.parseInt(br.readLine());

			if (n == 0)
				break;

			boolean flag = false;
			for (int i = 2; i <= 1000000; i++) {
				if (prime[i] && prime[n - i]) {
					flag = true;
					bw.write(n + " = " + i + " + " + (n - i) + "\n");
					break;
				}
			}
			if (!flag)
				bw.write("Goldbach's conjecture is wrong.\n");

		}
		bw.flush();

	}

}
