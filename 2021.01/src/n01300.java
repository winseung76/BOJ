import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01300 {

	static long N, k;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Long.parseLong(br.readLine());
		k = Long.parseLong(br.readLine());

		long max = N * N;

		long res = binSearch(1, max);

		bw.write(res + "\n");
		bw.flush();

	}

	public static long binSearch(long left, long right) {

		long pl = left;
		long pr = right;

		do {

			long pc = (pl + pr) / 2;

			long sum = 0;
			for (long i = 1; i <= N; i++) {
				sum += Math.min(pc / i, N);
			}

			if (sum < k)
				pl = pc + 1;
			else
				pr = pc - 1;

		} while (pl <= pr);

		return pl;
	}

}
