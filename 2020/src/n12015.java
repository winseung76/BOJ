import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class n12015 {

	static int N;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		String[] s = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(s[i]);

			if (list.size() == 0 || list.get(list.size() - 1) < n)
				list.add(n);
			else {
				int idx = binSearch(n, 0, list.size() - 1);
				list.set(idx, n);
			}
		}

		bw.write(list.size() + "\n");
		bw.flush();

	}

	public static int binSearch(int n, int left, int right) {

		int pl = left;
		int pr = right;

		do {

			int pc = (pl + pr) / 2;

			if (n == list.get(pc))
				return pc;

			if (n < list.get(pc))
				pr = pc - 1;
			else
				pl = pc + 1;

		} while (pl <= pr);

		return pl;
	}

}
