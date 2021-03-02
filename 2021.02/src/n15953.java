import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n15953 {

	static int[] first = { 1, 3, 6, 10, 15, 21 };
	static int[] second = { 1, 3, 7, 15, 31 };
	static int[] price1 = { 5000000, 3000000, 2000000, 500000, 300000, 100000 };
	static int[] price2 = { 5120000, 2560000, 1280000, 640000, 320000 };
	static int T;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			String[] sarr = br.readLine().split(" ");
			int a = Integer.parseInt(sarr[0]);
			int b = Integer.parseInt(sarr[1]);

			int price = 0;

			if (0 < a && a <= first[5]) {
				int idx1 = binSearch(first, a, 0, first.length - 1);
				price += price1[idx1];
			}
			if (0 < b && b <= second[4]) {
				int idx2 = binSearch(second, b, 0, second.length - 1);
				price += price2[idx2];
			}

			bw.write(price + "\n");

		}
		bw.flush();

	}

	public static int binSearch(int[] arr, int n, int left, int right) {

		int pl = left;
		int pr = right;

		do {

			int pc = (pl + pr) / 2;

			if (n == arr[pc])
				return pc;

			if (n < arr[pc])
				pr = pc - 1;
			else
				pl = pc + 1;

		} while (pl <= pr);

		return pl;
	}

}
