import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Vector;

public class n15683 {

	static int N, M;
	static char[][] map;
	static Vector<Pos> list = new Vector<>();
	static boolean[][] check;
	static int res = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		map = new char[N][M];
		check = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = s[j].charAt(0);

				if ('0' < map[i][j] && map[i][j] < '6')
					list.add(new Pos(i, j));
			}
		}

		getAns(0);

		bw.write(res + "\n");
		bw.flush();

	}

	public static void getAns(int idx) {

		if (idx == list.size()) {
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == '0')
						count++;
				}
			}
			res = Math.min(res, count);
			return;
		}

		Pos pos = list.get(idx);

		int n = 0;
		switch (map[pos.r][pos.c]) {

		case '1':
		case '3':
		case '4':
			n = 4;
			break;
		case '2':
			n = 2;
			break;

		case '5':
			n = 1;
			break;
		}

		for (int k = 0; k < n; k++) {
			Vector<Pos> list = setDirect(pos, k);

			for (int j = 0; j < list.size(); j++) {
				Pos p = list.get(j);
				map[p.r][p.c] = '#';
			}

			getAns(idx + 1);

			for (int j = 0; j < list.size(); j++) {
				Pos p = list.get(j);
				map[p.r][p.c] = '0';
			}

		}

	}

	public static Vector<Pos> setDirect(Pos pos, int idx) {

		Vector<Pos>[] arr = new Vector[4];
		for (int i = 0; i < arr.length; i++)
			arr[i] = new Vector();

		switch (map[pos.r][pos.c]) {
		case '1':

			for (int i = pos.c + 1; i < M; i++) {
				if (map[pos.r][i] == '6')
					break;
				if (map[pos.r][i] == '0')
					arr[0].add(new Pos(pos.r, i));
			}

			for (int i = pos.c - 1; i >= 0; i--) {
				if (map[pos.r][i] == '6')
					break;
				if (map[pos.r][i] == '0')
					arr[1].add(new Pos(pos.r, i));
			}

			for (int i = pos.r + 1; i < N; i++) {
				if (map[i][pos.c] == '6')
					break;
				if (map[i][pos.c] == '0')
					arr[2].add(new Pos(i, pos.c));
			}

			for (int i = pos.r - 1; i >= 0; i--) {
				if (map[i][pos.c] == '6')
					break;
				if (map[i][pos.c] == '0')
					arr[3].add(new Pos(i, pos.c));
			}

			break;
		case '2':

			for (int i = pos.c + 1; i < M; i++) {
				if (map[pos.r][i] == '6')
					break;
				if (map[pos.r][i] == '0')
					arr[0].add(new Pos(pos.r, i));
			}
			for (int i = pos.c - 1; i >= 0; i--) {
				if (map[pos.r][i] == '6')
					break;
				if (map[pos.r][i] == '0')
					arr[0].add(new Pos(pos.r, i));
			}

			for (int i = pos.r + 1; i < N; i++) {
				if (map[i][pos.c] == '6')
					break;
				if (map[i][pos.c] == '0')
					arr[1].add(new Pos(i, pos.c));
			}
			for (int i = pos.r - 1; i >= 0; i--) {
				if (map[i][pos.c] == '6')
					break;
				if (map[i][pos.c] == '0')
					arr[1].add(new Pos(i, pos.c));
			}

			break;
		case '3':

			for (int i = pos.r - 1; i >= 0; i--) {
				if (map[i][pos.c] == '6')
					break;
				if (map[i][pos.c] == '0') {
					arr[0].add(new Pos(i, pos.c));
					arr[3].add(new Pos(i, pos.c));
				}
			}
			for (int i = pos.c + 1; i < M; i++) {
				if (map[pos.r][i] == '6')
					break;
				if (map[pos.r][i] == '0') {
					arr[0].add(new Pos(pos.r, i));
					arr[1].add(new Pos(pos.r, i));
				}
			}

			for (int i = pos.r + 1; i < N; i++) {
				if (map[i][pos.c] == '6')
					break;
				if (map[i][pos.c] == '0') {
					arr[1].add(new Pos(i, pos.c));
					arr[2].add(new Pos(i, pos.c));
				}
			}

			for (int i = pos.c - 1; i >= 0; i--) {
				if (map[pos.r][i] == '6')
					break;
				if (map[pos.r][i] == '0') {
					arr[2].add(new Pos(pos.r, i));
					arr[3].add(new Pos(pos.r, i));
				}
			}

			break;

		case '4':

			for (int i = pos.c - 1; i >= 0; i--) {
				if (map[pos.r][i] == '6')
					break;
				if (map[pos.r][i] == '0') {
					arr[0].add(new Pos(pos.r, i));
					arr[2].add(new Pos(pos.r, i));
					arr[3].add(new Pos(pos.r, i));
				}

			}
			for (int i = pos.r - 1; i >= 0; i--) {
				if (map[i][pos.c] == '6')
					break;
				if (map[i][pos.c] == '0') {
					arr[0].add(new Pos(i, pos.c));
					arr[1].add(new Pos(i, pos.c));
					arr[3].add(new Pos(i, pos.c));
				}

			}
			for (int i = pos.c + 1; i < M; i++) {
				if (map[pos.r][i] == '6')
					break;
				if (map[pos.r][i] == '0') {
					arr[0].add(new Pos(pos.r, i));
					arr[1].add(new Pos(pos.r, i));
					arr[2].add(new Pos(pos.r, i));
				}

			}
			for (int i = pos.r + 1; i < N; i++) {
				if (map[i][pos.c] == '6')
					break;
				if (map[i][pos.c] == '0') {
					arr[1].add(new Pos(i, pos.c));
					arr[2].add(new Pos(i, pos.c));
					arr[3].add(new Pos(i, pos.c));
				}
			}

			break;
		case '5':

			for (int i = pos.c - 1; i >= 0; i--) {
				if (map[pos.r][i] == '6')
					break;
				if (map[pos.r][i] == '0') {
					arr[0].add(new Pos(pos.r, i));
				}

			}
			for (int i = pos.r - 1; i >= 0; i--) {
				if (map[i][pos.c] == '6')
					break;
				if (map[i][pos.c] == '0') {
					arr[0].add(new Pos(i, pos.c));
				}

			}
			for (int i = pos.c + 1; i < M; i++) {
				if (map[pos.r][i] == '6')
					break;
				if (map[pos.r][i] == '0') {
					arr[0].add(new Pos(pos.r, i));
				}

			}
			for (int i = pos.r + 1; i < N; i++) {
				if (map[i][pos.c] == '6')
					break;
				if (map[i][pos.c] == '0') {
					arr[0].add(new Pos(i, pos.c));
				}
			}
			break;
		}

		return arr[idx];
	}

	static class Pos {
		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;

		}
	}

}
