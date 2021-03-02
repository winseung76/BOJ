import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class n01963_소수경로 {
	static int[] count;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			count = new int[10000];
			for (int i = 1000; i < 10000; i++)
				count[i] = Integer.MAX_VALUE;

			String[] arr = br.readLine().split(" ");

			int res = bfs(arr[0], arr[1]);

			if (res == -1)
				bw.write("Impossible\n");
			else
				bw.write(res + "\n");

		}
		bw.flush();
	}

	public static int bfs(String A, String B) {
		Queue<String> q = new LinkedList<>();

		q.add(A);
		count[Integer.parseInt(A)] = 0;

		while (!q.isEmpty()) {
			String s = q.poll();
			int n = Integer.parseInt(s);

			// System.out.println(s + " " + count[n]);

			if (s.equals(B))
				return count[n];

			for (int i = 0; i < 4; i++) {

				char ch = s.charAt(i);

				int j;
				if (i == 0)
					j = 1;
				else
					j = 0;

				for (; j < 10; j++) {

					String str = s.substring(0, i) + j + s.substring(i + 1);
					int num = Integer.parseInt(str);

					if (checkPrime(num) && count[num] > count[n] + 1) {

						q.add(str);
						count[num] = count[n] + 1;
					}

				}
			}
		}
		return -1;
	}

	public static boolean checkPrime(int n) {

		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
