import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class n01325_효율적인_해킹 {
	static Vector<Integer>[] v;
	static int N, M;
	static boolean[] isvisited;
	static int[] result;
	static int max;
	// static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] arr = br.readLine().split(" ");
		N = Integer.parseInt(arr[0]);
		M = Integer.parseInt(arr[1]);

		v = new Vector[N + 1];
		result = new int[N + 1];

		for (int i = 0; i <= N; i++)
			v[i] = new Vector<>();

		for (int m = 0; m < M; m++) {
			arr = br.readLine().split(" ");
			int A = Integer.parseInt(arr[0]);
			int B = Integer.parseInt(arr[1]);

			v[B].add(A);
		}

		int res = 0;
		StringBuffer buf = new StringBuffer("");
		for (int i = 1; i <= N; i++) {

			isvisited = new boolean[N + 1];

			int count = hacking(i);
			result[i] = count;

	
		}
		for (int i = 1; i <= N; i++) {
			if (max == result[i])
				bw.write(i + " ");
		}
		bw.write("\n");
		bw.flush();

	}

	public static int hacking(int s) {

		Queue<Integer> q = new LinkedList<>();
		int cnt = 0;

		q.add(s);
		isvisited[s] = true;

		while (!q.isEmpty()) {
			int n = q.poll();

			for (int i = 0; i < v[n].size(); i++) {
				int tmp = v[n].get(i);

				if (!isvisited[tmp]) {
					q.add(tmp);
					isvisited[tmp] = true;
					cnt++;
				}
			}
		}

		max = Math.max(max, cnt);

		return cnt;
	}
}
