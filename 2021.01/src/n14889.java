import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class n14889 {

	static int N;
	static int[][] S;
	static int min = Integer.MAX_VALUE;
	static boolean[] visited;
	static Vector<Integer> team = new Vector();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		S = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				S[i][j] = Integer.parseInt(s[j - 1]);
			}
		}
		comb(1);
		bw.write(min + "\n");
		bw.flush();

	}

	public static void comb(int idx) {

		if (team.size() == N / 2) {
			int w1 = 0;
			for (int i = 0; i < team.size() - 1; i++) {
				int n = team.get(i);
				for (int j = i + 1; j < team.size(); j++) {
					int m = team.get(j);
					w1 += S[n][m] + S[m][n];
				}
			}

			Vector<Integer> other = new Vector();
			for (int i = 1; i <= N; i++) {
				if (!team.contains(i))
					other.add(i);
			}

			int w2 = 0;
			for (int i = 0; i < other.size() - 1; i++) {
				int n = other.get(i);
				for (int j = i + 1; j < other.size(); j++) {
					int m = other.get(j);
					w2 += S[n][m] + S[m][n];
				}
			}

			min = Math.min(min, Math.abs(w1 - w2));
			return;
		}

		for (int i = idx; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				team.add(i);
				comb(i + 1);
				visited[i] = false;
				team.remove((Integer) i);
			}
		}
	}

}
