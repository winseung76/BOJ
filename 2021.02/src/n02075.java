import java.io.*;
import java.util.*;

public class n02075 {

	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < N; i++) {
			String[] sarr = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				pq.offer(Integer.parseInt(sarr[j]));
			}
		}

		for (int i = 0; i < N - 1; i++) {
			pq.poll();
		}

		bw.write(pq.poll() + "\n");
		bw.flush();

	}

}
