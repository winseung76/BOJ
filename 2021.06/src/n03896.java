import java.io.*;
import java.util.*;

public class n03896 {

	static boolean[] prime = new boolean[1299710];
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < prime.length; i++) {
			prime[i] = true;
		}

		for (int n = 2; n * n < prime.length; n++) {
			if (prime[n]) {
				for (int i = 2; n * i < prime.length; i++) {
					prime[n * i] = false;
				}
			}
		}

		for (int i = 2; i < prime.length; i++) {
			if (prime[i]) {
				list.add(i);
			}
		}

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int k = Integer.parseInt(br.readLine());
			if (prime[k])
				bw.write(0 + "\n");
			else {
				bw.write(binSearch(k) + "\n");
			}
		}
		bw.flush();
	}

	public static int binSearch(int n) {

		int pl = 0;
		int pr = list.size() - 1;

		do {

			int pc = (pl + pr) / 2;

			if (list.get(pc) < n)
				pl = pc + 1;
			else if (list.get(pc) > n)
				pr = pc - 1;

		} while (pl <= pr);

		return list.get(pl) - list.get(pl - 1);
	}

}
