import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01913 {

	static int N;
	static int[][] arr;
	static int R, C;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1];

		int k = Integer.parseInt(br.readLine());

		int n = N * N;
		int r = 0;
		int c = 0;
		int cnt = N;
		boolean flag;

		while (true) {

			flag = false;

			c++;
			r++;
			for (int i = 0; i < cnt; i++) {

				if (n == k) {
					R = r;
					C = c;
				}

				arr[r++][c] = n--;

				if (n == 0) {
					flag = true;
					break;
				}
			}

			if (flag)
				break;

			r--;
			c++;
			for (int i = 0; i < cnt - 1; i++) {

				if (n == k) {
					R = r;
					C = c;
				}

				arr[r][c++] = n--;
			}

			c--;
			r--;
			for (int i = 0; i < cnt - 1; i++) {

				if (n == k) {
					R = r;
					C = c;
				}

				arr[r--][c] = n--;

			}

			r++;
			c--;
			for (int i = 0; i < cnt - 2; i++) {

				if (n == k) {
					R = r;
					C = c;
				}

				arr[r][c--] = n--;

			}

			cnt = cnt - 2;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				bw.write(arr[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.write(R + " " + C + "\n");
		bw.flush();

	}

}
