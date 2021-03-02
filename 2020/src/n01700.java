import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class n01700 {

	static int[] arr;
	static Pair[] order;
	static boolean[] use;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");

		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		order = new Pair[K + 1];

		for (int i = 0; i <= K; i++)
			order[i] = new Pair(i);

		arr = new int[K + 1];
		use = new boolean[K + 1];

		s = br.readLine().split(" ");
		for (int i = 1; i <= K; i++) {
			arr[i] = Integer.parseInt(s[i - 1]);
			order[arr[i]].list.add(i);
		}

		int rest = N;
		int cnt = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>();

		for (int i = 1; i <= K; i++) {

			int n = arr[i];

			order[n].list.remove((Integer) i);

			if (use[n]) {
				pq.remove(order[n]);
				pq.offer(order[n]);
			} else if (!use[n]) {
				if (rest > 0) {
					pq.offer(order[n]);
					use[n] = true;
					rest--;
				} else if (rest == 0) {

					Pair p = pq.poll();
					use[p.n] = false;

					pq.offer(order[n]);
					use[n] = true;
					cnt++;
				}
			}
		}

		bw.write(cnt + "\n");
		bw.flush();

	}

	static class Pair implements Comparable<Pair> {

		int n;
		List<Integer> list = new ArrayList<>();

		Pair(int n) {
			this.n = n;
		}

		@Override
		public int compareTo(Pair target) {

			if (this.list.size() == 0 && target.list.size() == 0)
				return 0;
			if (this.list.size() == 0)
				return -1;
			if (target.list.size() == 0)
				return 1;

			return this.list.get(0) <= target.list.get(0) ? 1 : -1;

		}
	}

}
