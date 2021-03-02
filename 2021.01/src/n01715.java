import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Vector;

public class n01715 {

	static int N;
	static int res;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}

		while (pq.size() > 1) {

			int sum = pq.poll() + pq.poll();

			pq.offer(sum);

			res += sum;
		}

		bw.write(res + "\n");
		bw.flush();

	}

}
