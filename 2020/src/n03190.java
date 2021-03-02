import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class n03190 {

	static int N, K, L;
	static int[][] map;
	static Vector<Integer> X = new Vector<>();
	static Vector<Integer> C = new Vector<>();
	static Deque<Pos> dq = new LinkedList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];

		for (int i = 0; i < K; i++) {
			String[] s = br.readLine().split(" ");
			int r = Integer.parseInt(s[0]);
			int c = Integer.parseInt(s[1]);

			map[r][c] = 1;
		}
		L = Integer.parseInt(br.readLine());

		for (int i = 0; i < L; i++) {
			String[] s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			char c = s[1].charAt(0);

			X.add(x);
			if (c == 'L')
				C.add(3);
			else if (c == 'D')
				C.add(1);
		}

		int time = 0;
		int[] x = { 1, 0, -1, 0 };
		int[] y = { 0, 1, 0, -1 };
		int d = 0;

		dq.offer(new Pos(1, 1));

		while (true) {

			time++;

			Pos head = dq.peekLast();
			Pos newHead = new Pos(head.r + y[d], head.c + x[d]);

			if (newHead.r < 1 || newHead.r > N || newHead.c < 1 || newHead.c > N) {
				bw.write(time + "\n");
				bw.flush();
				return;
			}

			Iterator<Pos> it = dq.iterator();
			while (it.hasNext()) {
				Pos pos = it.next();
				if (newHead.r == pos.r && newHead.c == pos.c) {
					bw.write(time + "\n");
					bw.flush();
					return;
				}
			}

			dq.offer(newHead);

			if (map[newHead.r][newHead.c] == 1)
				map[newHead.r][newHead.c] = 0;
			else
				dq.removeFirst();

			for (int i = 0; i < X.size(); i++) {
				if (time == X.get(i)) {
					d = (d + C.get(i)) % 4;
					break;
				}
			}
		}

	}

	static class Pos {

		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
