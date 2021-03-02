import java.io.*;
import java.util.Arrays;

public class n10815 {

	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		String[] sarr = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(sarr[i]);

		Arrays.sort(arr); // Á¤·Ä

		M = Integer.parseInt(br.readLine());
		sarr = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(sarr[i]);

			int idx = binSearch(n, 0, arr.length - 1);

			if (idx == -1)
				bw.write(0 + " ");
			else
				bw.write(1 + " ");
		}
		
		bw.flush();

	}

	public static int binSearch(int n, int left, int right) {

		int pl = left;
		int pr = right;

		do {

			int pc = (pl + pr) / 2;

			if (arr[pc] == n)
				return pc;

			if (arr[pc] < n)
				pl = pc + 1;
			else
				pr = pc - 1;

		} while (pl <= pr);

		return -1;
	}

}
