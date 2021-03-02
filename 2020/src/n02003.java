import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02003 {

	static int[] arr;
	static int N, M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] st = br.readLine().split(" ");
		N = Integer.parseInt(st[0]);
		M = Integer.parseInt(st[1]);

		arr = new int[N + 1];

		st = br.readLine().split(" ");

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st[i]);

		bw.write(getCount(arr) + "\n");
		bw.flush();

	}

	public static int getCount(int[] arr) {
		int s = 0, e = 0;
		int sum = 0;
		int cnt = 0;

		while (s < N) {
			if (sum == M) {
				cnt++;
				sum -= arr[s++];
			} else if (sum > M || e == N)
				sum -= arr[s++];
			else
				sum += arr[e++];
		}
		return cnt;
	}

}
