import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class n12851 {

	static int N, K;
	static int[] arr = new int[200001];
	static int cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		K = Integer.parseInt(sarr[1]);

		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.MAX_VALUE;

		bfs();

		bw.write(arr[K] + "\n");
		bw.write(cnt + "\n");
		bw.flush();

	}

	public static void bfs() {

		Queue<Pair> q = new LinkedList<>();

		arr[N] = 0;
		q.offer(new Pair(N, arr[N]));

		while (!q.isEmpty()) {

			Pair pair = q.poll();

			if (pair.n == K) {
				cnt++;
				continue;
			}

			int[] move = { pair.n + 1, pair.n - 1, pair.n * 2 };

			for (int i = 0; i < 3; i++) {

				if (0 <= move[i] && move[i] < arr.length && arr[move[i]] >= pair.cnt + 1) {

					arr[move[i]] = pair.cnt + 1;
					q.offer(new Pair(move[i], arr[move[i]]));

				}
			}

		}
	}

	static class Pair {

		int n, cnt;

		Pair(int n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}
	}

}
