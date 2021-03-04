import java.io.*;
import java.util.*;

public class n11497 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());

			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			String[] sarr = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				pq.offer(Integer.parseInt(sarr[i]));
			}

			int[] res = new int[N];
			res[N / 2] = pq.poll();
			int pl = N / 2 - 1;
			int pr = N / 2 + 1;
			while (!pq.isEmpty()) {
				if (pr < N)
					res[pr++] = pq.poll();
				if (pl >= 0)
					res[pl--] = pq.poll();
			}

			int max = Math.abs(res[0] - res[N - 1]);
			for (int i = 1; i < N; i++) {
				max = Math.max(Math.abs(res[i] - res[i - 1]), max);
			}
			bw.write(max + "\n");
		}
		bw.flush();

	}

}
