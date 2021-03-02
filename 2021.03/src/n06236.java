import java.io.*;

public class n06236 {

	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);

		arr = new int[N];

		int max = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
			sum += arr[i];
		}

		bw.write(binSearch(max, sum) + "\n");
		bw.flush();

	}

	public static int binSearch(int left, int right) {

		int pl = left;
		int pr = right;

		do {

			int pc = (pl + pr) / 2;
			int cnt = 1;
			int money = pc;
			for (int i = 0; i < N; i++) {
				if (arr[i] > money) {
					money = pc;
					cnt++;
				}
				money = money - arr[i];
			}

			if (cnt > M)
				pl = pc + 1;
			else
				pr = pc - 1;

		} while (pl <= pr);

		return pl;
	}

}
