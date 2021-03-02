import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class n09372_상근이의_여행 {
	static int[][] nations;
	static boolean[] isvisited;
	static int N, M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);

			nations = new int[N + 1][N + 1];
			isvisited = new boolean[N + 1];

			for (int m = 0; m < M; m++) {
				s = br.readLine().split(" ");
				int a = Integer.parseInt(s[0]);
				int b = Integer.parseInt(s[1]);
				nations[a][b] = 1;
				nations[b][a] = 1;
			}
			int res = tripMinPlane();
			bw.write(res + "\n");
		}
		bw.flush();
	}

	public static int tripMinPlane() {

		Queue<Integer> q = new LinkedList<>();
		int cnt = 0;

		q.add(1);
		isvisited[1] = true;

		while (!q.isEmpty()) {

			int n = q.poll();

			for (int i = 1; i <= N; i++) {
				if (nations[n][i] == 1 && !isvisited[i]) {
					q.add(i);
					isvisited[i] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}
}
