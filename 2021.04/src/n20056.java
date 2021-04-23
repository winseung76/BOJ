import java.io.*;
import java.util.*;

public class n20056 {

	static int N, M, K;
	static List<Integer>[][] board;
	static HashMap<Integer, Fireball> map = new HashMap<>();
	static int num;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);

		board = new ArrayList[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				board[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int r = Integer.parseInt(input[0]);
			int c = Integer.parseInt(input[1]);
			int m = Integer.parseInt(input[2]);
			int s = Integer.parseInt(input[3]);
			int d = Integer.parseInt(input[4]);

			map.put(num++, new Fireball(r, c, m, s, d));
			board[r][c].add(i);
		}

		move();
		bw.write(getSum() + "\n");
		bw.flush();

	}

	public static void move() {

		for (int k = 0; k < K; k++) {

			for (int m = 0; m < num; m++) {
				if (map.containsKey(m)) {

					Fireball fb = map.get(m);

					int nr = (fb.r + fb.s * dr[fb.d]);
					int nc = (fb.c + fb.s * dc[fb.d]);

					if (nr <= 0)
						nr = N - Math.abs(nr) % N;
					else
						nr = (nr - 1) % N + 1;

					if (nc <= 0)
						nc = N - Math.abs(nc) % N;
					else
						nc = (nc - 1) % N + 1;

					board[nr][nc].add(m);
					board[fb.r][fb.c].remove((Integer) m);
					fb.r = nr;
					fb.c = nc;
				}
			}

			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {

					if (board[r][c].size() >= 2) {

						int even = 0;
						int odd = 0;
						int sumM = 0;
						int sumS = 0;

						for (int n : board[r][c]) {
							Fireball fb = map.get(n);

							sumM += fb.m;
							sumS += fb.s;

							if (fb.d % 2 == 0)
								even++;
							else
								odd++;

							map.remove((Integer) n);
						}

						int nm = sumM / 5;
						int ns = sumS / board[r][c].size();
						int nd = 0;
						if (even > 0 && odd > 0)
							nd = 1;

						board[r][c].clear();

						if (nm > 0) {
							for (int i = 0; i < 4; i++) {
								board[r][c].add(num);
								map.put(num++, new Fireball(r, c, nm, ns, nd));
								nd += 2;
							}
						}

					}
				}
			}
		}
	}

	public static int getSum() {

		int sum = 0;

		Set<Integer> set = map.keySet();
		Iterator<Integer> it = set.iterator();

		while (it.hasNext()) {
			Fireball fb = map.get(it.next());
			sum += fb.m;
		}

		return sum;
	}

	static class Fireball {

		int r, c, m, s, d;

		Fireball(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
}
