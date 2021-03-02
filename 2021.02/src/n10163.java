import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10163 {

	static int[][] arr = new int[101][101];
	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			String[] sarr = br.readLine().split(" ");

			int R = Integer.parseInt(sarr[0]);
			int C = Integer.parseInt(sarr[1]);
			int W = Integer.parseInt(sarr[2]);
			int H = Integer.parseInt(sarr[3]);

			for (int r = R; r < R + W; r++) {
				for (int c = C; c < C + H; c++) {
					arr[r][c] = i;
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			int cnt = 0;

			for (int r = 0; r < 101; r++) {
				for (int c = 0; c < 101; c++) {
					if (arr[r][c] == i)
						cnt++;
				}
			}
			bw.write(cnt + "\n");
		}

		bw.flush();
	}

}
