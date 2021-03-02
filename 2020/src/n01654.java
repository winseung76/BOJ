import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01654 {

	static int[] arr;
	static int N, K;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		K = Integer.parseInt(s[0]);
		N = Integer.parseInt(s[1]);

		arr = new int[K];

		int max = 0;
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}

		bw.write(binSearch(arr, max + 1) + "\n");
		bw.flush();

	}

	public static long binSearch(int[] arr, int n) {

		long pl = 1;
		long pr = n - 1;

		do {

			long pc = (pl + pr) / 2;

			long cnt = getCount(pc);

			if (cnt < (long) N)
				pr = pc - 1;
			else
				pl = pc + 1;

		} while (pl <= pr);

		return pr;

	}

	public static long getCount(long n) {

		long cnt = 0;

		for (int i = 0; i < K; i++)
			cnt += arr[i] / n;

		return cnt;

	}

}
