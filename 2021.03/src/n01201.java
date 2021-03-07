import java.io.*;

public class n01201 {

	static int N, M, K;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);
		K = Integer.parseInt(sarr[2]);

		int[] end = new int[M + 1]; // 각 묶음당 마지막 수를 저장

		int n = N - K;

		if (M + K - 1 > N || M * K < N)
			bw.write(-1 + "\n");
		else {

			end[1] = K;

			if (M - 1 > 0) {
				int cnt = n % (M - 1); // 나머지
				int k = n / (M - 1);
				for (int i = 2; i <= M; i++) {
					if (cnt > 0) { // 아직 배분안한 나머지가 존재하면
						end[i] = end[i - 1] + k + 1; // +1 추가해준다.
						cnt--;
					} else
						end[i] = end[i - 1] + k;
				}
			}

			for (int i = 1; i <= M; i++) {
				for (int j = end[i]; j >= end[i - 1] + 1; j--) {
					bw.write(j + " ");
				}
			}
		}

		bw.flush();
	}
}
