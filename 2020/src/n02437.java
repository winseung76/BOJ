import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class n02437 {

	static int[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		arr = new int[N];

		int sum = 0;
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(s[i]);
			sum += arr[i];
		}
		Arrays.sort(arr);

		for (int n = 1; n <= sum + 1; n++) {
			int m = n;
			for (int i = N - 1; i >= 0; i--) {

				if (m >= arr[i])
					m = m - arr[i];

			}
			if (m > 0) {
				bw.write(n + "\n");
				bw.flush();
				return;
			}
		}

	}

}
