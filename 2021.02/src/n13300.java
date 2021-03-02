import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n13300 {

	static int N, K;
	static int[][] arr = new int[7][2];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		K = Integer.parseInt(sarr[1]);

		for (int i = 0; i < N; i++) {
			sarr = br.readLine().split(" ");
			int S = Integer.parseInt(sarr[0]);
			int Y = Integer.parseInt(sarr[1]);

			arr[Y][S]++;
		}

		int cnt = 0;

		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j < 2; j++) {
				cnt += arr[i][j] / K;

				if (arr[i][j] % K > 0)
					cnt += 1;
			}
		}
		bw.write(cnt + "\n");
		bw.flush();

	}

}
