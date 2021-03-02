import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n15988 {

	static long[] arr = new long[1000001];
	static final int MOD = 1000000009;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;

		for (int i = 4; i < arr.length; i++) {
			arr[i] = (arr[i - 3] % MOD) + (arr[i - 2] % MOD) + (arr[i - 1] % MOD);
			arr[i] = arr[i] % MOD;
		}

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			bw.write(arr[n] + "\n");
		}

		bw.flush();
	}

}
