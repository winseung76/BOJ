import java.io.*;
import java.util.*;

public class n17825 {

	static int[] arr = new int[10];
	static int[] pos = new int[4];
	static int[] path = new int[4];
	static Vector<Integer>[] board = new Vector[40];
	static HashSet<Integer> set = new HashSet<>();
	static int max;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < 10; i++)
			arr[i] = Integer.parseInt(input[i]);

		initBoard();
		List<Integer> list = new ArrayList<>();
		solve(0, list, 0);

		bw.write(max + "\n");
		bw.flush();

	}

	public static void solve(int idx, List<Integer> list, int score) {

		if (idx == 10) {
			max = Math.max(max, score);
			return;
		}

		for (int i = 0; i < 4; i++) {

			if (pos[i] == -1)
				continue;

			int chk = path[i];
			int newPos = move(i, arr[idx]);

			boolean flag = true;

			if (newPos != -1) {
				for (int j = 0; j < 4; j++) {
					if (i != j) {
						if (set.contains(newPos) && path[i] == path[j] && pos[j] == newPos) {
							flag = false;
							break;
						}
						if (!set.contains(newPos) && pos[j] == newPos) {
							flag = false;
							break;
						}
					}
				}
			}

			if (!flag) {
				path[i] = chk;
				continue;
			}

			int tmp = pos[i];
			pos[i] = newPos;

			if (pos[i] != -1)
				score += pos[i];
			list.add(pos[i]);
			solve(idx + 1, list, score);
			list.remove(list.size() - 1);
			if (pos[i] != -1)
				score -= pos[i];

			pos[i] = tmp;
			path[i] = chk;

		}
	}

	public static int move(int idx, int cnt) {

		int n = pos[idx];

		for (int i = 0; i < cnt; i++) {

			if (n == 40)
				return -1;

			if (path[idx] == 0)
				n = board[n].get(0);

			if (path[idx] == 1)
				n = board[n].get(board[n].size() / 2);

			if (path[idx] == 2)
				n = board[n].get(board[n].size() - 1);

			if (n == 25)
				path[idx]++;

		}

		if (n == 10 || n == 20)
			path[idx] = 1;
		else if (n == 30 && path[idx] < 2)
			path[idx]++;

		return n;

	}

	public static void initBoard() {

		for (int i = 0; i < 40; i++)
			board[i] = new Vector<>();

		for (int i = 0; i < 40; i += 2)
			board[i].add(i + 2);

		board[10].add(13);
		board[13].add(16);
		board[16].add(19);
		board[19].add(25);

		board[20].add(22);
		board[22].add(24);
		board[24].add(25);

		board[30].add(28);
		board[28].add(27);
		board[27].add(26);
		board[26].add(25);

		board[25].add(30);
		board[30].add(35);
		board[35].add(40);

		set.add(16);
		set.add(22);
		set.add(24);
		set.add(26);
		set.add(28);
		set.add(30);
	}

}
