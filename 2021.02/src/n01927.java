import java.util.*;
import java.io.*;

public class n01927 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());

			if (n == 0) {
				if (pq.isEmpty())
					bw.write(0 + "\n");
				else
					bw.write(pq.poll() + "\n");
			} else
				pq.offer(n);
		}
		bw.flush();

	}
}
