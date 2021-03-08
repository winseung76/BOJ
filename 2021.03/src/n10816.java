import java.io.*;
import java.util.*;

public class n10816 {

	static int N, M;
	static int[] arr;
	static HashMap<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		String[] sarr = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(sarr[i]);
			map.computeIfAbsent(arr[i], key -> new Integer(0));
			map.put(arr[i], map.get(arr[i]) + 1);
		}

		Arrays.sort(arr);

		M = Integer.parseInt(br.readLine());
		sarr = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(sarr[i]);
			int res = binSearch(n, 0, N - 1);
			bw.write(res + " ");
		}

		bw.flush();

	}

	public static int binSearch(int n, int left, int right) {

		int pl = left;
		int pr = right;
		int cnt = 0;

		do {

			int pc = (pl + pr) / 2;

			if (arr[pc] == n) {
				cnt = map.get(n);
				break;
			}
			if (arr[pc] < n)
				pl = pc + 1;
			else if (arr[pc] > n)
				pr = pc - 1;

		} while (pl <= pr);

		return cnt;
	}
}
