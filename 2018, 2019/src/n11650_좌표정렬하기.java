import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n11650_좌표정렬하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.parseInt(br.readLine());
		Point[] points = new Point[size];

		for (int i = 0; i < size; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			points[i] = new Point(x, y);

		}
		Arrays.sort(points);

		for (int i = 0; i < size; i++) {
			bw.write(points[i].getX() + " " + points[i].getY() + "\n");
			bw.flush();
		}
	}

	static class Point implements Comparable {
		private int x;
		private int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		@Override
		public int compareTo(Object o) {

			if (this.x < ((Point) o).x) {
				return -1;
			} else if (this.x == ((Point) o).x) {
				if (this.y < ((Point) o).y)
					return -1;
				else if (this.y == ((Point) o).y)
					return 0;
				else
					return 1;
			} else {
				return 1;
			}
		}
	}
}
