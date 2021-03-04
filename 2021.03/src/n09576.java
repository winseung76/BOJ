import java.io.*;
import java.util.*;

public class n09576 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String[] sarr = br.readLine().split(" ");
			int N = Integer.parseInt(sarr[0]);
			int M = Integer.parseInt(sarr[1]);

			boolean[] book = new boolean[N + 1];
			int[] cnt = new int[N + 1];
			cnt[0] = Integer.MAX_VALUE;
			PriorityQueue<Range> pq = new PriorityQueue<>(M,
					(Range r1, Range r2) -> (r1.b == r2.b) ? r2.a - r1.a : r1.b - r2.b);

			for (int m = 0; m < M; m++) {
				sarr = br.readLine().split(" ");
				int a = Integer.parseInt(sarr[0]);
				int b = Integer.parseInt(sarr[1]);
				pq.offer(new Range(a, b));
				for (int i = a; i <= b; i++)
					cnt[i]++;
			}

			int res = 0;

			while (!pq.isEmpty()) {
				Range r = pq.poll();

				for (int i = r.a; i <= r.b; i++) {
					if (!book[i]) {
						book[i] = true;
						res++;
						break;
					}
				}
			}
			bw.write(res + "\n");

		}
		bw.flush();
	}

	static class Range {

		int a, b;

		Range(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
}
