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

		boolean[] check = new boolean[(int) (max - min + 1)];

		for (long i = 2; i <= Math.sqrt(max); i++) {

			long square = i * i;
			double t = (double) min / (double) square;
			long start = (long) ((Math.ceil(t) * square) - min);

			for (long j = start; j < check.length; j += square) {

				check[(int) j] = true;
			}
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
