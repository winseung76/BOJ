import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n11653 {

	static int[] prime;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		prime = new int[N];

		boolean flag;
		int idx = 0;
		for (int i = 2; i <= N; i++) {
			flag = false;
			for (int j = 0; prime[j] > 0 && prime[j] * prime[j] <= N; j++) {
				if (i % prime[j] == 0) {
					flag = true;
					break;
				}
			}
			if (!flag)
				prime[idx++] = i;
		}

		while (N > 1) {
			for (int i = 0; i < idx; i++) {
				if (N % prime[i] == 0) {
					bw.write(prime[i] + "\n");
					N = N / prime[i];
					break;
				}
			}
		}
		bw.flush();

	}

}
