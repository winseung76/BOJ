import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class n01613_¿ª»ç {

	static int n, k;
	static ArrayList<Short>[] list;
	static boolean[] check;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] arr = br.readLine().split(" ");

		n = Integer.parseInt(arr[0]);
		k = Integer.parseInt(arr[1]);

		list = new ArrayList[n + 1];
		check = new boolean[n + 1];

		for (int i = 0; i <= n; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < k; i++) {

			arr = br.readLine().split(" ");

			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);

			list[a].add((short) b);
		}

		int s = Integer.parseInt(br.readLine());

		for (int i = 0; i < s; i++) {

			arr = br.readLine().split(" ");

			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);

			if (bfs(a, b))
				bw.write("-1\n");
			else if (bfs(b, a))
				bw.write("1\n");
			else
				bw.write("0\n");

		}
		bw.flush();

	}

	public static boolean bfs(int n, int ans) {

		Queue<Short> q = new LinkedList<>();

		for (int i = 0; i <= n; i++)
			check[i] = false;

		q.add((short) n);
		check[n] = true;

		while (!q.isEmpty()) {

			int p = q.poll();

			for (int i = 0; i < list[p].size(); i++) {
				int m = list[p].get(i);

				if (m == ans)
					return true;

				if (!check[m]) {
					q.add((short) m);
					check[m] = true;
				}
			}
		}

		return false;
	}
}
