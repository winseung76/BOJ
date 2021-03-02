import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02578 {

	static boolean[][] board = new boolean[5][5];
	static Pos[] pos = new Pos[26];
	static int res;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 5; i++) {
			String[] sarr = br.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				int n = Integer.parseInt(sarr[j]);
				pos[n] = new Pos(i, j);
			}
		}

		boolean bingo = false;

		for (int i = 0; i < 5; i++) {
			String[] sarr = br.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				int n = Integer.parseInt(sarr[j]);
				Pos p = pos[n];

				board[p.r][p.c] = true;

				int cnt = 0;
				boolean flag;

				for (int r = 0; r < 5; r++) {
					flag = true;
					for (int c = 0; c < 5; c++) {
						if (!board[r][c]) {
							flag = false;
							break;
						}
					}
					if (flag)
						cnt++;
				}

				for (int c = 0; c < 5; c++) {
					flag = true;
					for (int r = 0; r < 5; r++) {
						if (!board[r][c]) {
							flag = false;
							break;
						}
					}
					if (flag)
						cnt++;
				}

				flag = true;
				for (int k = 0; k < 5; k++) {
					if (!board[k][k]) {
						flag = false;
						break;
					}
				}
				if (flag)
					cnt++;

				flag = true;
				for (int k = 0; k < 5; k++) {
					if (!board[k][4 - k]) {
						flag = false;
						break;
					}
				}
				if (flag)
					cnt++;

				if (cnt >= 3) {
					res = (i * 5 + j + 1);
					bingo = true;
					break;
				}

			}
			if (bingo)
				break;

		}
		bw.write(res + "\n");
		bw.flush();

	}

	static class Pos {

		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
