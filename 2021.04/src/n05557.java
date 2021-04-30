import java.io.*;

public class n05557 {

	static int N;
	static long[][] arr;
	static long cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new long[21][N];

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int ans = Integer.parseInt(input[N - 1]);

		arr[n][1]++;

		for (int i = 2; i < N; i++) {
			n = Integer.parseInt(input[i - 1]); // 3

			for (int j = 0; j <= 20; j++) {
				if (arr[j][i - 1] > 0) {

					int res = j + n;
					if (0 <= res && res <= 20) {
						arr[res][i] += arr[j][i - 1];
					}

					res = j - n;
					if (0 <= res && res <= 20) {
						arr[res][i] += arr[j][i - 1];
					}
				}

			}
		}

		bw.write(arr[ans][N - 1] + "\n");
		bw.flush();

	}

}
