import java.io.*;
import java.util.*;

public class n12738 {

	static int N;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		String[] sarr = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {

			int n = Integer.parseInt(sarr[i]);

			if (list.isEmpty() || list.get(list.size() - 1) < n)
				list.add(n);
			else {
				int pos = binSearch(0, list.size() - 1, n);
				list.set(pos, n);
			}
		}

		bw.write(list.size() + "\n");
		bw.flush();

	}

	public static int binSearch(int left, int right, int n) {

		int pl = left;
		int pr = right;

		do {

			int pc = (pl + pr) / 2;

			if (list.get(pc) == n)
				return pc;

			if (list.get(pc) < n)
				pl = pc + 1;
			else
				pr = pc - 1;

		} while (pl <= pr);

		return pl;
	}

}
