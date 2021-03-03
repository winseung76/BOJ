import java.io.*;
import java.util.Arrays;

public class n02467 {

	static int N;
	static long[] arr;
	static long min = Long.MAX_VALUE;
	static int a, b;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new long[N];

		String[] sarr = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(sarr[i]);

		Arrays.sort(arr);

		for (int i = 0; i < N - 1; i++) {

			int idx = binSearch((int) (-arr[i]), i + 1, N - 1);
			long sum = Math.abs(arr[i] + arr[idx]);

			if (min > sum) {
				a = (int) arr[i];
				b = (int) arr[idx];
				min = sum;
			}
		}

		bw.write(a + " " + b + "\n");
		bw.flush();

	}

	public static int binSearch(int n, int left, int right) {

		int pl = left;
		int pr = right;

		do {

			int pc = (pl + pr) / 2;

			if (arr[pc] == n)
				return pc;

			if (arr[pc] < n)
				pl = pc + 1;
			else
				pr = pc - 1;

		} while (pl <= pr);

		
		if (pl > right)
			return pr;
		if (pr < left)
			return pl;

		if (Math.abs(n - arr[pl]) < Math.abs(n - arr[pr]))
			return pl;
		else
			return pr;
	}
}
