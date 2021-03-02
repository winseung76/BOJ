import java.util.Arrays;
import java.util.Scanner;

public class n11651_좌표정렬하기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Point[] p = new Point[N];

		for (int i = 0; i < N; i++) {
			p[i] = new Point(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(p);
		for (int i = 0; i < N; i++) {
			System.out.println(p[i].x + " " + p[i].y);
		}

	}

	static class Point implements Comparable {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Object o) {
			Point p = (Point) o;

			if (this.y < p.y)
				return -1;
			else if (this.y > p.y)
				return 1;
			else {
				if (this.x < p.x)
					return -1;
				else if (this.x == p.x)
					return 0;
				else
					return 1;
			}
		}
	}
}
