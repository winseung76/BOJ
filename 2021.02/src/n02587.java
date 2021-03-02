import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class n02587 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int sum = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < 5; i++) {
			int n = Integer.parseInt(br.readLine());
			sum += n;
			pq.offer(n);
		}

		bw.write(sum / 5 + "\n");
		pq.poll();
		pq.poll();
		bw.write(pq.poll() + "\n");
		bw.flush();

	}

}
