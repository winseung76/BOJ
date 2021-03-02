import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class n15650 {

	static int N, M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);

		Vector<Integer> list = new Vector<>();
		solve(list, 1);
	}

	public static void solve(Vector<Integer> list, int n) {

		if (list.size() == M) {
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
			return;
		}

		for (int i = n; i <= N; i++) {
			list.add(i);
			solve(list, i + 1);
			list.remove((Integer) i);
		}
	}

}
