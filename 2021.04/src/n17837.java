import java.io.*;
import java.util.*;

public class n17837 {

	static int N, K;
	static int[][] board;
	static Vector<Integer>[][] pos; // 0번으로 갈수록 아래에 있고, 번호가 커질수록 위에 있음
	static Mal[] mal;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);

		board = new int[N + 1][N + 1];
		mal = new Mal[K + 1];
		pos = new Vector[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			input = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				board[i][j] = Integer.parseInt(input[j - 1]);
				pos[i][j] = new Vector<>();
			}
		}

		for (int i = 1; i <= K; i++) {
			input = br.readLine().split(" ");
			int r = Integer.parseInt(input[0]);
			int c = Integer.parseInt(input[1]);
			int d = Integer.parseInt(input[2]);
			mal[i] = new Mal(r, c, d);
			pos[r][c].add(i);
		}

		bw.write(solve() + "\n");
		bw.flush();

	}

	public static int solve() {

		int[] mr = { 0, 0, 0, -1, 1 };
		int[] mc = { 0, 1, -1, 0, 0 };

		int cnt = 0;

		while (true) {

			if (cnt > 1000)
				return -1;

			cnt++;

			for (int i = 1; i <= K; i++) {

				Mal m = mal[i];

				int nr = m.r + mr[m.d];
				int nc = m.c + mc[m.d];

				if ((nr < 1 || nr > N) || (nc < 1 || nc > N) || board[nr][nc] == 2) {
					int d = changeDirect(m.d); // 방향 반대로 바꿈
					nr = m.r + mr[d]; // 방향 바뀐 후, 반대쪽으로 한칸 이동한 위치
					nc = m.c + mc[d];

					m.d = d;
				}

				if ((1 <= nr && nr <= N) && (1 <= nc && nc <= N) && board[nr][nc] == 0) {

					List<Integer> tmp = new ArrayList<>();
					boolean flag = false;

					for (int n : pos[m.r][m.c]) { // 원래 위치에서 vector에서 저장된 아래에 말부터 꺼냄
						if (n == i)
							flag = true;

						if (flag) {
							pos[nr][nc].add(n);
							tmp.add(n);
						}
					}

					for (int n : tmp) {
						pos[mal[n].r][mal[n].c].remove((Integer) n);
						mal[n].r = nr;
						mal[n].c = nc;
					}
				}

				else if ((1 <= nr && nr <= N) && (1 <= nc && nc <= N) && board[nr][nc] == 1) {

					List<Integer> tmp = new ArrayList<>();

					for (int j = pos[m.r][m.c].size() - 1; j >= 0; j--) {
						int n = pos[m.r][m.c].get(j);

						pos[nr][nc].add(n);
						tmp.add(n);

						if (n == i)
							break;
					}

					for (int n : tmp) {
						pos[mal[n].r][mal[n].c].remove((Integer) n);
						mal[n].r = nr;
						mal[n].c = nc;
					}
				}
				for (int k = 1; k <= K; k++) {
					if (pos[mal[k].r][mal[k].c].size() >= 4)
						return cnt;
				}
			}
		}

	}

	public static int changeDirect(int i) {

		if (i == 1)
			return 2;
		else if (i == 2)
			return 1;
		else if (i == 3)
			return 4;
		else
			return 3;
	}

	public static class Mal {

		int r, c, d;

		Mal(int r, int c, int d) {

			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

}
