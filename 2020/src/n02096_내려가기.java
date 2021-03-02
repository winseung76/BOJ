import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02096_내려가기 {

	static int[][] max, min;
	static int res1, res2;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		max = new int[N][3];
		min = new int[N][3];

		for (int i = 0; i < N; i++) {
			String[] arr = br.readLine().split(" ");
			max[i][0] = min[i][0] = Integer.parseInt(arr[0]);
			max[i][1] = min[i][1] = Integer.parseInt(arr[1]);
			max[i][2] = min[i][2] = Integer.parseInt(arr[2]);

			if (i > 0) {
				max[i][0] += Math.max(max[i - 1][0], max[i - 1][1]);
				max[i][1] += Math.max(max[i - 1][0], Math.max(max[i - 1][1], max[i - 1][2]));
				max[i][2] += Math.max(max[i - 1][1], max[i - 1][2]);

				min[i][0] += Math.min(min[i - 1][0], min[i - 1][1]);
				min[i][1] += Math.min(min[i - 1][0], Math.min(min[i - 1][1], min[i - 1][2]));
				min[i][2] += Math.min(min[i - 1][1], min[i - 1][2]);
			}

		}

		res1 = Math.max(max[N - 1][0], Math.max(max[N - 1][1], max[N - 1][2]));
		res2 = Math.min(min[N - 1][0], Math.min(min[N - 1][1], min[N - 1][2]));

		bw.write(res1 + " " + res2 + "\n");
		bw.flush();
	}
}
