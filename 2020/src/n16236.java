import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class n16236 {

	static int N;
	static int[][] arr;
	static Pos start;
	static int cnt;
	static int size = 2;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
				if (arr[i][j] == 9)
					start = new Pos(i, j, 0);
			}
		}
		bw.write(bfs(start) + "\n");
		bw.flush();

	}

	public static int bfs(Pos shark) {

		int move = 0;
		Pos pos;

		while ((pos = findFish(shark)) != null) {

			move += pos.cnt;
			cnt++;
	
			if (cnt == size) {
				cnt = 0;
				size++;
			}

			arr[pos.r][pos.c] = 9;
			arr[shark.r][shark.c] = 0;

			shark.r = pos.r;
			shark.c = pos.c;
		}
		return move;
	}

	public static Pos findFish(Pos shark) {

		int[] r = { -1, 0, 0, 1 };
		int[] c = { 0, -1, 1, 0 };
		Queue<Pos> q = new LinkedList<>();
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		visited = new boolean[N][N];

		q.offer(shark);
		visited[shark.r][shark.c] = true;

		while (!q.isEmpty()) {

			Pos pos = q.poll();
			if (!pq.isEmpty() && pos.cnt == pq.peek().cnt)
				return pq.poll();

			for (int i = 0; i < 4; i++) {
				int nr = pos.r + r[i];
				int nc = pos.c + c[i];

				if ((0 <= nr && nr < N) && (0 <= nc && nc < N) && !visited[nr][nc]) {
					if (0 <= arr[nr][nc] && arr[nr][nc] <= size) {
						if (0 < arr[nr][nc] && arr[nr][nc] < size)
							pq.offer(new Pos(nr, nc, pos.cnt + 1));

						q.offer(new Pos(nr, nc, pos.cnt + 1));
						visited[nr][nc] = true;
					}
				}
			}
		}

		return null;

	}

	static class Pos implements Comparable<Pos> {
		int r, c, cnt;

		Pos(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Pos o) {

			if (r == o.r) {
				return c - o.c;
			}
			return r - o.r;
		}
	}

}
