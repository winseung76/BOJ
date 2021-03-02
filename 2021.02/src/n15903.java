import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class n15903 {

	static int n, m;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		n = Integer.parseInt(sarr[0]);
		m = Integer.parseInt(sarr[1]);

		PriorityQueue<Long> pq = new PriorityQueue<>();

		sarr = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			pq.offer(Long.parseLong(sarr[i]));
		}

		int cnt = m;

		while (cnt > 0) {
			long a = pq.poll();
			long b = pq.poll();
			
			long sum = a + b;

			pq.offer(sum);
			pq.offer(sum);

			cnt--;
		}

		long res = 0;
		while (!pq.isEmpty()) {
			res += pq.poll();
		}

		bw.write(res + "\n");
		bw.flush();

	}

}
