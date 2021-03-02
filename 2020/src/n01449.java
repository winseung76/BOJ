import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class n01449 {

	static int[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int L = Integer.parseInt(s[1]);

		arr = new int[N];

		s = br.readLine().split(" ");

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(s[i]);

		Arrays.sort(arr);

		int sum = 0;
		int cnt = 1;

		for (int i = 1; i < N; i++) {
			int diff = arr[i] - arr[i - 1];
			sum += diff;
			if (sum >= L) {
				sum = 0;
				cnt++;
			}
		}
		bw.write(cnt + "\n");
		bw.flush();

	}

}
