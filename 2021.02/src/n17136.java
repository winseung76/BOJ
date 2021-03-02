import java.io.*;

public class n17136 {

	static int[][] paper = new int[10][10];
	static int[] use = { 0, 0, 0, 0, 0, 0 };
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 10; i++) {
			String[] sarr = br.readLine().split(" ");
			for (int j = 0; j < 10; j++) {
				paper[i][j] = Integer.parseInt(sarr[j]);
			}
		}

		comb(0, 0);

		if (min == Integer.MAX_VALUE)
			bw.write(-1 + "\n");
		else
			bw.write(min + "\n");

		bw.flush();

	}

	public static void comb(int sr, int sc) {

		if (sr >= 10) { // 배열의 끝까지 탐색을 마치면
			int cnt = 0;
			for (int i = 1; i <= 5; i++)
				cnt += use[i];

			min = Math.min(min, cnt);
			return;
		}

		if (paper[sr][sc] == 1) {

			for (int size = 5; size >= 1; size--) {

				boolean res = solve(new Pos(sr, sc), size);

				if (!res)
					continue;

				for (int i = sr; i < sr + size; i++) {
					for (int j = sc; j < sc + size; j++) {
						paper[i][j] = 0;
					}
				}
				use[size]++;

				if (sc == 9) // 현재 위치가 열의 마지막이면
					comb(sr + 1, 0); // 다음 행으로 이동한다.
				else
					comb(sr, sc + 1); // 열의 마지막이 아니라면 다음열로 이동한다.

				for (int i = sr; i < sr + size; i++) {
					for (int j = sc; j < sc + size; j++) {
						paper[i][j] = 1;
					}
				}
				use[size]--;

			}
		}

		else {
			if (sc == 9)
				comb(sr + 1, 0);
			else
				comb(sr, sc + 1);
		}
	}

	public static boolean solve(Pos pos, int size) {

		boolean flag = true;

		for (int i = pos.r; i < pos.r + size; i++) {
			for (int j = pos.c; j < pos.c + size; j++) {
				if (i >= 10 || j >= 10 || paper[i][j] == 0) {
					flag = false;
					break;
				}
			}

			if (!flag)
				break;
		}

		if (flag && use[size] < 5)
			return true;

		// size 크기의 색종이를 붙일 수 없거나, 색종이를 모두 다 사용했으면 false
		return false;

	}

	static class Pos {

		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
