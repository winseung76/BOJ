import java.io.*;
import java.util.*;

public class n08980 {

	static int N, C, M;
	static int max;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		C = Integer.parseInt(sarr[1]);
		M = Integer.parseInt(br.readLine());

		PriorityQueue<BoxInfo> pq = new PriorityQueue<>(M,
				(BoxInfo b1, BoxInfo b2) -> (b1.recv == b2.recv) ? b1.send - b2.send : b1.recv - b2.recv);

		for (int i = 0; i < M; i++) {
			sarr = br.readLine().split(" ");
			int s = Integer.parseInt(sarr[0]);
			int r = Integer.parseInt(sarr[1]);
			int n = Integer.parseInt(sarr[2]);
			pq.offer(new BoxInfo(s, r, n));
		}

		int[] send = new int[N + 1];
		int[] receive = new int[N + 1];

		while (!pq.isEmpty()) {

			BoxInfo bi = pq.poll();

			int sum = 0;
			for (int i = 1; i <= bi.send; i++) {
				sum += send[i];
				sum -= receive[i];
			}

			if (sum < C) {
				if (sum + bi.box <= C) {
					send[bi.send] += bi.box;
					receive[bi.recv] += bi.box;
				}

				else if (sum + bi.box > C) {
					send[bi.send] += C - sum;
					receive[bi.recv] += C - sum;
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			max += send[i];
		}

		bw.write(max + "\n");
		bw.flush();

	}

	static class BoxInfo {

		int send, recv, box;

		BoxInfo(int send, int recv, int box) {
			this.send = send;
			this.recv = recv;
			this.box = box;
		}
	}
}
