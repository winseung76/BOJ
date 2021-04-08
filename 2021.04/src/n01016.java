import java.io.*;

public class n01016 {

	static long min, max;
	static boolean[] prime = new boolean[1000001];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		min = Long.parseLong(input[0]);
		max = Long.parseLong(input[1]);

		/*
		 * for (int i = 2; i <= 1000000; i++) prime[i] = true;
		 * 
		 * for (int i = 2; i * i <= 1000000; i++) { if (prime[i]) { for (int k = 2; i *
		 * k <= 1000000; k++) { prime[i * k] = false; } } }
		 */

		boolean[] check = new boolean[(int) (max - min + 1)];

		for (long i = 2; i <= Math.sqrt(max); i++) {
			// if (prime[i]) {
			long square = i * i;
			double t = (double) min / (double) square;
			long start = (long) ((Math.ceil(t) * square) - min);

			//System.out.println(check.length + " " + start);
			for (long j = start; j < check.length; j += square) {
				// System.out.println(j);
				check[(int) j] = true;
			}
			// }
		}

		long cnt = 0;

		for (int i = 0; i < check.length; i++) {
			if (!check[i])
				cnt++;
		}

		bw.write(cnt + "\n");
		bw.flush();
	}
}
