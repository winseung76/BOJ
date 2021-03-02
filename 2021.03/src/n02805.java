import java.io.*;

public class n02805 {

	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);

		arr = new int[N];
		sarr = br.readLine().split(" ");

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(sarr[i]);

		bw.write(binSearch(0, 1000000000) + "\n");
		bw.flush();
	}

	public static int binSearch(int left, int right) {

		int pl = left;
		int pr = right;

		do {
			int pc = (pl + pr) / 2;

			long sum = 0;
			for (int i = 0; i < N; i++) {
				if (arr[i] > pc)
					sum += arr[i] - pc;
			}

			if (sum >= M)
				pl = pc + 1;
			else
				pr = pc - 1;

		} while (pl <= pr);

		return pr;

	}
}
