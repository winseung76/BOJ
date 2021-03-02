import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10448 {

	static boolean[] check = new boolean[1001];
	static int[] arr = new int[50];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 1; i < arr.length; i++) {
			arr[i] = (i * (i + 1)) / 2;
		}

		solve(0, 0);

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int K = Integer.parseInt(br.readLine());

			if (check[K])
				bw.write(1 + "\n");
			else
				bw.write(0 + "\n");

		}
		bw.flush();

	}

	public static void solve(int n, int cnt) {

		if (cnt == 3) {
			if (n <= 1000)
				check[n] = true;
			return;
		}

		for (int i = 1; i < arr.length; i++) {
			solve(n + arr[i], cnt + 1);
		}

	}

}
