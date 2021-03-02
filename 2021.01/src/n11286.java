import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class n11286 {

	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		PriorityQueue<Num> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());

			if (n != 0)
				pq.offer(new Num(n));
			else {
				if (pq.isEmpty())
					bw.write(0 + "\n");
				else
					bw.write(pq.poll().n + "\n");
			}
		}
		bw.flush();

	}

	static class Num implements Comparable<Num> {

		int n;

		Num(int n) {
			this.n = n;
		}

		@Override
		public int compareTo(Num o) {

			if (Math.abs(n) == Math.abs(o.n)) {
				return n - o.n;
			}

			return Math.abs(n) - Math.abs(o.n);
		}

	}

}
