import java.io.*;
import java.util.*;

public class n02550 {

	static int N;
	static HashMap<Integer, Integer> map = new HashMap<>();
	static List<Integer> list = new ArrayList<>();
	static int[] arr, org;
	static Pair[] track;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		org = new int[N];
		arr = new int[N];
		track = new Pair[N];

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			map.put(Integer.parseInt(input[i]), i);
			org[i] = Integer.parseInt(input[i]);
		}

		input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = map.get(Integer.parseInt(input[i]));
		}

		getLIS();

		bw.write(list.size() + "\n");

		Collections.sort(list);

		for (int n : list) {
			bw.write(n + " ");
		}
		bw.write("\n");
		bw.flush();

	}

	public static void getLIS() {

		for (int i = 0; i < N; i++) {
			if (list.size() == 0 || list.get(list.size() - 1) < arr[i]) {
				list.add(arr[i]);
				track[i] = new Pair(arr[i], list.size() - 1);
			}

			else {
				int idx = binSearch(arr[i]);
				list.set(idx, arr[i]);
				track[i] = new Pair(arr[i], idx);
			}

		}

		int idx = list.size() - 1;

		for (int i = N - 1; i >= 0; i--) {
			if (track[i].idx == idx) {
				list.set(idx, org[track[i].n]);
				idx--;
			}
		}

	}

	public static int binSearch(int n) {

		int pl = 0;
		int pr = list.size() - 1;

		do {

			int pc = (pl + pr) / 2;

			if (list.get(pc) < n)
				pl = pc + 1;
			else
				pr = pc - 1;

		} while (pl <= pr);

		return pl;
	}

	static class Pair {

		int n, idx;

		Pair(int n, int idx) {
			this.n = n;
			this.idx = idx;
		}
	}

}
