import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class n09205_맥주_마시면서_걸어가기 {

	static ArrayList<Pos> store;
	static Pos start, end;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			store = new ArrayList<>();

			for (int j = 0; j < n + 2; j++) {
				String[] s = br.readLine().split(" ");

				int x = Integer.parseInt(s[0]);
				int y = Integer.parseInt(s[1]);

				if (j == 0)
					start = new Pos(x, y);
				else if (j == n + 1)
					end = new Pos(x, y);
				else
					store.add(new Pos(x, y));
			}

			if (dist(end, start) <= 1000) // 편의점 들릴 필요 없이 한번에 도착 가능한 경우
				bw.write("happy\n");

			else {
				boolean res = false;
				
				for (int j = 0; j < n; j++) {
					Pos pos = store.get(j);

					for (int k = 0; k < n; k++)
						store.get(k).visited = false;

					if (dist(pos, start) <= 1000) {
						if (bfs(pos)) {
							res = true;
							break;
						}
					}
				}

				if (res)
					bw.write("happy\n");
				else
					bw.write("sad\n");
			}
		}
		bw.flush();
	}

	public static boolean bfs(Pos pos) {

		Queue<Pos> q = new LinkedList<>();

		q.add(pos);
		pos.visited = true;

		while (!q.isEmpty()) {

			Pos p = q.poll();

			for (int i = 0; i < store.size(); i++) {
				Pos s = store.get(i);

				if (!s.visited && dist(s, p) <= 1000) {
					if (dist(end, s) <= 1000)
						return true;

					q.add(s);
					s.visited = true;
				}
			}
		}
		return false;
	}

	public static int dist(Pos a, Pos b) {

		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}

	static class Pos {
		int x, y;
		boolean visited;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
