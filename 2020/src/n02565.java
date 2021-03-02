import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class n02565 {

	static int[] A = new int[501];
	static int[] B = new int[501];
	static Vector<Integer> list1 = new Vector<>();
	static Vector<Integer> list2 = new Vector<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);

			A[a] = b;
			B[b] = a;
		}

		for (int i = 1; i <= 500; i++) {

			if (A[i] > 0) {

				if (list1.size() == 0 || list1.get(list1.size() - 1) < A[i])
					list1.add(A[i]);
				else {
					int idx = binSearch(list1, A[i], 0, list1.size() - 1);
					list1.set(idx, A[i]);
				}
			}

			if (B[i] > 0) {

				if (list2.size() == 0 || list2.get(list2.size() - 1) < B[i])
					list2.add(B[i]);
				else {

					int idx = binSearch(list2, B[i], 0, list2.size() - 1);
					list2.set(idx, B[i]);
				}
			}
		}

		bw.write(n - Math.max(list1.size(), list2.size()) + "\n");
		bw.flush();

	}

	public static int binSearch(Vector<Integer> list, int n, int left, int right) {

		int pl = left;
		int pr = right;

		do {

			int pc = (pl + pr) / 2;

			if (list.get(pc) > n)
				pr = pc - 1;
			else if (list.get(pc) < n)
				pl = pc + 1;

		} while (pl <= pr);

		return pl;

	}

}
