import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01038 {

	static long[] arr = new long[1000001];
	static int N;
	static int idx;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		arr[idx++] = 0;

		for (int size = 1; size <= 10; size++) {
			for (int s = 1; s <= 9; s++) {
				solve(size, s, (long) (s * Math.pow(10, size - 1)), 2);
			}
		}

		if (N > 0 && arr[N] == 0)
			arr[N] = -1;

		bw.write(arr[N] + "\n");
		bw.flush();

	}

	public static void solve(int size, int n, long num, int pos) {

		if (pos > size) {
			if (num <= Long.MAX_VALUE)
				arr[idx++] = num;
			return;
		}

		for (int i = 0; i < n; i++) {
			num += i * Math.pow(10, size - pos);
			solve(size, i, num, pos + 1);
			num -= i * Math.pow(10, size - pos);
		}
	}

}
