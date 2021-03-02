import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class n10974 {

	static int N;
	static boolean[] visited;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];

		Vector<Integer> list = new Vector<>();
		solve(list);
		bw.flush();

	}

	public static void solve(Vector<Integer> list) throws Exception {

		if (list.size() == N) {
			for (int i = 0; i < list.size(); i++)
				bw.write(list.get(i) + " ");
			bw.write("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				list.add(i);

				solve(list);

				visited[i] = false;
				list.remove((Integer) i);
			}
		}

	}

}
