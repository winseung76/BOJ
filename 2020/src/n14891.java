import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n14891 {

	static int[][] wheel = new int[5][8];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 1; i <= 4; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++)
				wheel[i][j] = str.charAt(j) - '0';
		}

		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);

			int n = a + 1;
			int d = -b;
			int right = wheel[a][2];
			while (n <= 4 && wheel[n][6] == Math.abs(right - 1)) {
				right = wheel[n][2];
				if (d == 1) {
					int tmp = wheel[n][7];
					for (int j = 6; j >= 0; j--)
						wheel[n][j + 1] = wheel[n][j];
					wheel[n][0] = tmp;
				} else if (d == -1) {
					int tmp = wheel[n][0];
					for (int j = 1; j < 8; j++)
						wheel[n][j - 1] = wheel[n][j];
					wheel[n][7] = tmp;
				}
				n = n + 1;
				d = -d;
			}
			n = a - 1;
			d = -b;
			int left = wheel[a][6];
			while (n >= 1 && wheel[n][2] == Math.abs(left - 1)) {
				left = wheel[n][6];
				if (d == 1) {
					int tmp = wheel[n][7];
					for (int j = 6; j >= 0; j--)
						wheel[n][j + 1] = wheel[n][j];
					wheel[n][0] = tmp;
				} else if (d == -1) {
					int tmp = wheel[n][0];
					for (int j = 1; j < 8; j++)
						wheel[n][j - 1] = wheel[n][j];
					wheel[n][7] = tmp;
				}
				n = n - 1;
				d = -d;
			}

			if (b == 1) {
				int tmp = wheel[a][7];
				for (int j = 6; j >= 0; j--)
					wheel[a][j + 1] = wheel[a][j];
				wheel[a][0] = tmp;
			} else if (b == -1) {
				int tmp = wheel[a][0];
				for (int j = 1; j < 8; j++)
					wheel[a][j - 1] = wheel[a][j];
				wheel[a][7] = tmp;
			}

		}

		int sum = 0;
		for (int i = 1; i <= 4; i++) {
			if (wheel[i][0] == 1)
				sum += Math.pow(2, i - 1);
		}
		bw.write(sum + "\n");
		bw.flush();
	}

}
