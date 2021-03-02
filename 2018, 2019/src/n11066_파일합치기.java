import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n11066_파일합치기 {
	static int[][] cost;
	static int[] sum;
	static int[] size;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int K = Integer.parseInt(br.readLine());

			cost = new int[K][K];
			sum = new int[K];
			size = new int[K];

			String[] arr = br.readLine().split(" ");
			for (int k = 0; k < K; k++) {
				size[k] = Integer.parseInt(arr[k]);
				cost[k][k] = 0;

				if (k == 0)
					sum[k] = size[k];
				else {
					sum[k] += sum[k - 1] + size[k];
					cost[k - 1][k] = size[k - 1] + size[k];
				}
			}

			for (int g = 2; g < K; g++) {
				for (int start = 0; start < K - g; start++) {
					int end = start + g;

					cost[start][end] = Integer.MAX_VALUE;

					for (int j = start; j < end; j++) {
						cost[start][end] = Math.min(cost[start][end], cost[start][j] + cost[j + 1][end]);
					}
					if (start == 0)
						cost[start][end] += sum[end];
					else
						cost[start][end] += (sum[end] - sum[start - 1]);
				}

			}
			bw.write(cost[0][K - 1] + "\n");

		}
		bw.flush();
	}
}
