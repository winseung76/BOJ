import java.io.*;
import java.util.*;

public class n02331 {

	static int A, P;
	static List<Integer> list = new ArrayList<>();
	static boolean[] visited = new boolean[237000];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		A = Integer.parseInt(input[0]);
		P = Integer.parseInt(input[1]);

		solve();

		bw.write(list.size() + "\n");
		bw.flush();

	}

	public static void solve() {

		int n = A;

		visited[n] = true;
		list.add(n);

		while (true) {
			int m = n;
			int sum = 0;
			while (m > 0) {
				sum += Math.pow(m % 10, P);
				m = m / 10;
			}

			if (visited[sum]) {
				if (!list.contains((Integer) sum))
					break;

				list.remove((Integer) sum);
			}

			else {
				visited[sum] = true;
				list.add(sum);
			}

			n = sum;
		}
	}
}
