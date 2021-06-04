import java.io.*;
import java.util.*;

public class n12014 {

	static int N, K;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			List<Integer> list = new ArrayList<>();
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			K = Integer.parseInt(input[1]);
			input = br.readLine().split(" ");

			for (int i = 0; i < N; i++) {
				int n = Integer.parseInt(input[i]);

				if (list.size() == 0 || list.get(list.size() - 1) < n)
					list.add(n);
				else {
					int idx = binSearch(list, 0, list.size() - 1, n);
					list.set(idx, n);
				}
			}

			bw.write("Case #" + (t + 1) + "\n");
			if (list.size() < K)
				bw.write(0 + "\n");
			else
				bw.write(1 + "\n");
		}
		bw.flush();
	}

	public static int binSearch(List<Integer> list, int left, int right, int n) {

		int pl = left;
		int pr = right;

		do {
			int pc = (pl + pr) / 2;

			if (list.get(pc) < n)
				pl = pc + 1;
			else
				pr = pc - 1;

		} while (pl <= pr);

		return pl;
	}

}
