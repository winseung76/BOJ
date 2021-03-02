import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class n02231 {

	static int M = Integer.MAX_VALUE, N;
	static Vector<Integer> list = new Vector<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		int p = 0;
		int sum = 0;
		while (true) {

			if (N <= sum + 9 * (Math.pow(10, p) + 1))
				break;

			sum += 9 * (Math.pow(10, p) + 1);
			p++;

		}

		getMin(p, 0);

		if (M == Integer.MAX_VALUE)
			bw.write(0 + "\n");
		else
			bw.write(M + "\n");
		bw.flush();

	}

	public static void getMin(int p, int sum) {

		if (p < 0) {

			if (sum == N) {
				int res = sum;

				for (int i = 0; i < list.size(); i++)
					res -= list.get(i);

				M = Math.min(M, res);
			}

			return;
		}

		for (int n = 0; n <= 9; n++) {
			sum += n * (Math.pow(10, p) + 1);

			list.add(n);

			getMin(p - 1, sum);

			sum -= n * (Math.pow(10, p) + 1);

			list.remove((Integer) n);
		}

	}

}
