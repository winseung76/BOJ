import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01182 {

	static int N, S;
	static int[] arr;
	static int cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		S = Integer.parseInt(sarr[1]);
		arr = new int[N];

		sarr = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(sarr[i]);

		for (int i = 1; i <= N; i++)
			solve(0, i, 0, 0);

		bw.write(cnt + "\n");
		bw.flush();

	}

	public static void solve(int idx, int num, int count, int sum) {

		if (count == num) {
			if (sum == S)
				cnt++;
			return;
		}

		for (int i = idx; i < N; i++) {
			solve(i + 1, num, count + 1, sum + arr[i]);
		}

	}

}
