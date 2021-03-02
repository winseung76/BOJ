import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class n02631 {

	static int N;
	static int[] arr;
	static Vector<Integer> list = new Vector<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());

			if (list.isEmpty() || list.get(list.size() - 1) < arr[i])
				list.add(arr[i]);

			else {
				int idx = binSearch(arr[i], 0, list.size() - 1);
				list.set(idx, arr[i]);
			}

		}
		int res = N - list.size();

		bw.write(res + "\n");
		bw.flush();

	}

	public static int binSearch(int n, int left, int right) {

		int pl = left;
		int pr = right;

		do {

			int pc = (pl + pr) / 2;

			if (n > list.get(pc))
				pl = pc + 1;

			else if (n < list.get(pc))
				pr = pc - 1;

		} while (pl <= pr);

		return pl;
	}

}
