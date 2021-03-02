import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class n01516{

	static int N;
	static int[] time, preTime;
	static Vector<Pair>[] arr;
	static int[] indegree;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		time = new int[N + 1];
		preTime = new int[N + 1];
		arr = new Vector[N + 1];
		indegree = new int[N + 1];

		for (int i = 0; i <= N; i++)
			arr[i] = new Vector();

		for (int i = 1; i <= N; i++) {
			String[] s = br.readLine().split(" ");

			time[i] = Integer.parseInt(s[0]);
			for (int j = 1; j < s.length - 1; j++) {
				arr[Integer.parseInt(s[j])].add(new Pair(i, time[i]));
				indegree[i]++;
			}
		}

		getMinTime();

		for (int i = 1; i <= N; i++)
			bw.write(time[i] + "\n");
		bw.flush();

	}

	public static void getMinTime() {

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0)
				q.offer(i);
		}
		
		while (!q.isEmpty()) {

			int n = q.poll();

			for (Pair p : arr[n]) {
				indegree[p.n]--;
				preTime[p.n] = Math.max(preTime[p.n], time[n]);

				if (indegree[p.n] == 0) {
					time[p.n] += preTime[p.n];
					q.offer(p.n);
				}
			}
		}

	}

	static class Pair {
		int n;
		int w;

		Pair(int n, int w) {
			this.n = n;
			this.w = w;
		}
	}

}
