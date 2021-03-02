import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Vector;

public class n16235 {

	static int N, M, K;
	static int[][] A;
	static PriorityQueue<Integer>[][] board;
	static int[][] nutrient;
	static int cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);
		K = Integer.parseInt(sarr[2]);

		A = new int[N + 1][N + 1];
		board = new PriorityQueue[N + 1][N + 1];
		nutrient = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			sarr = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(sarr[j - 1]);
				board[i][j] = new PriorityQueue<>();
				nutrient[i][j] = 5;
			}
		}

		for (int i = 0; i < M; i++) {
			sarr = br.readLine().split(" ");
			int x = Integer.parseInt(sarr[0]);
			int y = Integer.parseInt(sarr[1]);
			int z = Integer.parseInt(sarr[2]);
			board[x][y].add(z);
		}

		solve();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cnt += board[i][j].size();
			}
		}

		bw.write(cnt + "\n");
		bw.flush();

	}

	public static void solve() {

		int year = 0;

		while (year < K) {

			springNSummer();
			fallNWinter();
			year++;
		}

	}

	public static void springNSummer() {

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {

				PriorityQueue<Integer> tmp = new PriorityQueue<>();

				while (!board[i][j].isEmpty()) {

					int age = board[i][j].peek();

					if (nutrient[i][j] < age)
						break;

					else {
						nutrient[i][j] -= age;
						tmp.offer(board[i][j].poll() + 1);
					}
				}

				Iterator<Integer> it = board[i][j].iterator();

				while (it.hasNext()) {

					int age = it.next();
					nutrient[i][j] += age / 2;
				}

				board[i][j] = tmp;
			}
		}
	}

	public static void fallNWinter() {

		int[] r = { 0, 1, 0, -1, 1, 1, -1, -1 };
		int[] c = { 1, 0, -1, 0, 1, -1, 1, -1 };

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {

				Iterator<Integer> it = board[i][j].iterator();

				while (it.hasNext()) {

					int age = it.next();

					if (age % 5 == 0) {
						for (int k = 0; k < 8; k++) {
							int nr = i + r[k];
							int nc = j + c[k];

							if ((1 <= nr && nr <= N) && (1 <= nc && nc <= N)) {
								board[nr][nc].add(1);
							}
						}
					}
				}

				nutrient[i][j] += A[i][j];

			}
		}
	}

}
