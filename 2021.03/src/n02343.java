import java.io.*;

public class n02343 {

	static int N, M;
	static int[] lesson;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);

		lesson = new int[N];

		int max = 0;
		sarr = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			lesson[i] = Integer.parseInt(sarr[i]);
			max = Math.max(max, lesson[i]);
		}

		bw.write(binSearch(max, 1000000000) + "\n");
		bw.flush();

	}

	public static int binSearch(int left, int right) {

		int pl = left;
		int pr = right;

		do {
			int pc = (pl + pr) / 2;
			int cnt = 1;
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += lesson[i];
				if (sum > pc) {
					sum = lesson[i];
					cnt++;
				}
			}

			if (cnt > M)
				pl = pc + 1;
			else
				pr = pc - 1;

		} while (pl <= pr);

		return pl;
	}
}
