import java.io.*;
import java.util.*;

public class n13711 {

	static List<Integer> list = new ArrayList<>();
	static HashMap<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			map.put(Integer.parseInt(input[i]), i);
		}

		input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int n = map.get(Integer.parseInt(input[i]));

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

			if (list.get(pc) < n)
				pl = pc + 1;
			else
				pr = pc - 1;

		} while (pl <= pr);

		return pl;
	}

}
