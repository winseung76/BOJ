import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02581 {

	static int M, N;
	static int[] prime;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		M = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());

		prime = new int[N + 1];

		int idx = 0;
		boolean flag;
		for (int i = 2; i <= N; i++) {
			flag = false;
			for (int j = 0; prime[j] != 0 && prime[j] * prime[j] <= i; j++) {
				if (i % prime[j] == 0) {
					flag = true;
					break;
				}
			}
			if (!flag)
				prime[idx++] = i;
		}

		int sum = 0;
		int min = 0;
		flag = false;
		for (int i = 0; i < idx; i++) {
			if (prime[i] >= M) {
				if (!flag)
					min = prime[i];
				sum += prime[i];
				flag = true;
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
