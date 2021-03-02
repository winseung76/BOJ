import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n14890 {

	static int N, L;
	static int[][] map;
	static int res;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		L = Integer.parseInt(s[1]);

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(s[j]);
		}

		int cnt = 0;
		int preN;
		boolean flag;
		boolean desc;
		int max;
		for (int i = 0; i < N; i++) {
			preN = map[i][0];
			max = map[i][0];
			cnt = 1;
			flag = true;
			desc = false;

			for (int j = 1; j < N; j++) {

				max = Math.max(max, map[i][j]);

				if (Math.abs(preN - map[i][j]) > 1) {
					flag = false;
					break;
				}

				if (preN > map[i][j]) {
					if (preN < max && cnt < L) {
						flag = false;
						break;
					}
					desc = true;
					cnt = 1;
				} else if (preN < map[i][j]) {
					if (cnt < L) {
						flag = false;
						break;
					} else if (desc) {
						if (cnt - L < L) {
							flag = false;
							break;
						}
					}
					desc = false;
					cnt = 1;
				}

				else if (preN == map[i][j])
					cnt++;

				preN = map[i][j];
			}
			if (desc && cnt < L)
				flag = false;

			if (flag)
				res++;

		}

		for (int j = 0; j < N; j++) {
			preN = map[0][j];
			max = map[0][j];
			cnt = 1;
			flag = true;
			desc = false;

			for (int i = 1; i < N; i++) {

				max = Math.max(max, map[i][j]);

				if (Math.abs(preN - map[i][j]) > 1) {
					flag = false;
					break;
				}

				if (preN > map[i][j]) {
					if (preN < max && cnt < L) {
						flag = false;
						break;
					}
					desc = true;
					cnt = 1;
				} else if (preN < map[i][j]) {
					if (cnt < L) {
						flag = false;
						break;
					} else if (desc) {
						if (cnt - L < L) {
							flag = false;
							break;
						}
					}
					desc = false;
					cnt = 1;
				}

				else if (preN == map[i][j])
					cnt++;

				preN = map[i][j];
			}
			if (desc && cnt < L)
				flag = false;

			if (flag)
				res++;

		}

		bw.write(res + "\n");
		bw.flush();

	}

}
