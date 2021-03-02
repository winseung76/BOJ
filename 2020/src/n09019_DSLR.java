import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class n09019_DSLR {
	static boolean[] isvisited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			isvisited = new boolean[10000];

			String[] arr = br.readLine().split(" ");

			String res = calculate(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
			bw.write(res + "\n");

		}
		bw.flush();
	}

	public static String calculate(int A, int B) {

		Queue<Pair> q = new LinkedList<>();
		char[] chs = { 'D', 'S', 'L', 'R' };

		q.add(new Pair(A, ""));
		isvisited[A] = true;

		while (!q.isEmpty()) {
			Pair p = q.poll();
			int n = p.n;
			int len = p.str.length();

			if (n == B)
				return p.str;

			for (int i = 0; i < 4; i++) {
				int nn = command(n, chs[i]);

				if (!isvisited[nn]) {
					q.add(new Pair(nn, p.str + chs[i]));
					isvisited[nn] = true;
				}
			}
		}

		return null;
	}

	public static int command(int n, char ch) {

		String s = String.valueOf(n);
		int size = s.length();

		switch (ch) {
		case 'D':
			return (n * 2) % 10000;
		case 'S':
			if (n == 0)
				return 9999;
			else
				return n - 1;
		case 'L':

			return (n % 1000) * 10 + (n / 1000);
		case 'R':
			int m = n / 10;
			int d = n % 10;

			return d * 1000 + m;
		default:
			return -1;
		}
	}

	static class Pair {
		int n;
		String str;

		Pair(int n, String str) {
			this.n = n;
			this.str = str;
		}
	}
}
