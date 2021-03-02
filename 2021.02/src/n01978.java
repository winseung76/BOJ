import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01978 {

	static int N;
	static int[] arr;
	static boolean[] prime;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		int max = 0;

		String[] sarr = br.readLine().split(" ");
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(sarr[i]);
			max = Math.max(max, arr[i]);
		}
		prime = new boolean[max + 1];

		for (int i = 2; i < prime.length; i++)
			prime[i] = true; // 1을 제외한 범위의 모든 수를 소수라고 가정

		for (int n = 2; n * n <= max; n++) {
			if (prime[n]) { // n이 소수이면 n을 제외한 n의 배수를 모두 제거
				for (int k = 2; n * k <= max; k++) {
					prime[n * k] = false;
				}
			}
		}

		int cnt = 0;

		for (int i = 0; i < arr.length; i++) {
			if (prime[arr[i]])
				cnt++;
		}

		bw.write(cnt + "\n");
		bw.flush();

	}

}
