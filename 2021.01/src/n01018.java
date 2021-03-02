import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01018 {

	static int N, M;
	static char[][] arr;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		arr = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		getChessBoard();

		bw.write(min + "\n");
		bw.flush();

	}

	public static void getChessBoard() {

		char[] turn = { 'B', 'W' };

		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {

				for (int k = 0; k < 2; k++) {

					int cnt = 0;
					char t = turn[k];

					for (int r = i; r < i + 8; r++) {
						for (int c = j; c < j + 8; c++) {
							if (arr[r][c] != t) {
								cnt++;
							}
							if (c < j + 7)
								t = (t == 'B') ? 'W' : 'B';
						}
					}

					min = Math.min(min, cnt);
				}

			}
		}
	}

}
