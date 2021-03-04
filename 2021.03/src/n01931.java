import java.io.*;
import java.util.*;

public class n01931 {

	static int N;
	static int cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		PriorityQueue<Class> pq = new PriorityQueue<>(N,
				(Class c1, Class c2) -> c1.end == c2.end ? c1.start - c2.start : c1.end - c2.end);

		for (int i = 0; i < N; i++) {
			String[] sarr = br.readLine().split(" ");
			int s = Integer.parseInt(sarr[0]);
			int e = Integer.parseInt(sarr[1]);
			pq.offer(new Class(s, e));
		}

		int end = 0;
		while (!pq.isEmpty()) {

			Class c = pq.poll();

			if (c.start >= end) {
				end = c.end;
				cnt++;
			}
		}

		bw.write(cnt + "\n");
		bw.flush();

	}

	static class Class {

		int start, end;

		Class(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
