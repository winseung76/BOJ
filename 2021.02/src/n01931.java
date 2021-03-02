import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class n01931 {

	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		PriorityQueue<Pair> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			String[] sarr = br.readLine().split(" ");
			int start = Integer.parseInt(sarr[0]);
			int end = Integer.parseInt(sarr[1]);

			pq.offer(new Pair(start, end));
		}

		int cnt = 0;
		int finish = 0;

		while (!pq.isEmpty()) {

			Pair pair = pq.poll();

			if (pair.start < finish)
				continue;

			finish = pair.end;
			cnt++;
		}

		bw.write(cnt + "\n");
		bw.flush();

	}

	static class Pair implements Comparable<Pair> {

		int start;
		int end;

		Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Pair o) {

			if (end == o.end)
				return start - o.start;

			return end - o.end;
		}
	}

}
