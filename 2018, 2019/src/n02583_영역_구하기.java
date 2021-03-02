import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n02583_����_���ϱ� {
	private static int m, n, k;
	private static boolean[][] isvisited;

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		k = sc.nextInt();
		isvisited = new boolean[n][m];

		// ��ĥ�� ������ �湮ó�� �Ѵ�.
		for (int i = 0; i < k; i++) {
			int left_x = sc.nextInt();
			int left_y = sc.nextInt();
			int right_x = sc.nextInt();
			int right_y = sc.nextInt();

			for (int j = left_x; j < right_x; j++) {
				for (int k = left_y; k < right_y; k++) {
					isvisited[j][k] = true;
				}
			}
		}

		// �� ������ �ϳ��� ���鼭
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// �湮���� ���� ���� ������ ����� ������ �ϳ��� �湮�ϸ� ť�� �ִ´�.
				if (!isvisited[i][j]) {
					isvisited[i][j] = true;
					list.add(bfs(i, j));
				}
			}
		}
		list.sort(null);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + " ");

	}

	public static int bfs(int i, int j) {
		Queue<Point> q = new LinkedList<Point>();
		int count = 0;
		int[] x = { -1, 0, 1, 0 };
		int[] y = { 0, -1, 0, 1 };

		q.add(new Point(i, j));

		while (!q.isEmpty()) {
			Point p = q.poll();
			count++;

			for (int k = 0; k < 4; k++) {
				int _x = p.x + x[k];
				int _y = p.y + y[k];

				if (_x >= 0 && _x < n && _y >= 0 && _y < m && !isvisited[_x][_y]) {
					isvisited[_x][_y] = true;
					q.add(new Point(_x, _y));
				}
			}
		}
		return count;
	}

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
