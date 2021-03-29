import java.io.*;
import java.util.*;

public class n02162 {

	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		Line[] arr = new Line[N];
		DisjointSet ds = new DisjointSet(N);
		ds.makeSet();

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			double x1 = Double.parseDouble(input[0]);
			double y1 = Double.parseDouble(input[1]);
			double x2 = Double.parseDouble(input[2]);
			double y2 = Double.parseDouble(input[3]);

			arr[i] = new Line(i, new Point(x1, y1), new Point(x2, y2));
		}

		for (int i = 0; i < N; i++) {
			Line line1 = arr[i];

			for (int j = i + 1; j < N; j++) {
				Line line2 = arr[j];

				if (checkCross(line1, line2)) {
					ds.union(line1.n, line2.n);
				}
			}
		}

		bw.write(ds.getGroupCount() + "\n");
		bw.write(ds.getMaxGroup() + "\n");
		bw.flush();

	}

	public static boolean checkCross(Line line1, Line line2) {

		if ((line1.start.x == line2.start.x && line1.start.y == line2.start.y)
				|| (line1.start.x == line2.end.x && line1.start.y == line2.end.y)
				|| (line1.end.x == line2.start.x && line1.end.y == line2.start.y)
				|| (line1.end.x == line2.end.x && line1.end.y == line2.end.y))
			return true;

		double res1 = ccw(line1.start, line1.end, line2.start) * ccw(line1.start, line1.end, line2.end);
		double res2 = ccw(line2.start, line2.end, line1.start) * ccw(line2.start, line2.end, line1.end);

		if (res1 == 0 && res2 == 0) {

			double a = Math.pow(line1.start.x, 2) + Math.pow(line1.start.y, 2);
			double b = Math.pow(line1.end.x, 2) + Math.pow(line1.end.y, 2);
			double c = Math.pow(line2.start.x, 2) + Math.pow(line2.start.y, 2);
			double d = Math.pow(line2.end.x, 2) + Math.pow(line2.end.y, 2);

			return (d - a) * (b - c) >= 0;

		}

		return res1 <= 0 && res2 <= 0;
	}

	public static double ccw(Point a, Point b, Point c) {

		double res = a.x * b.y + b.x * c.y + c.x * a.y - (a.y * b.x + b.y * c.x + c.y * a.x);

		return res;

	}

	static class Line {

		int n;
		Point start, end;

		Line(int n, Point start, Point end) {
			this.n = n;
			this.start = start;
			this.end = end;
		}
	}

	static class Point {

		double x, y;

		Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	static class DisjointSet {

		int[] parent, rank, nodeCount;

		DisjointSet(int size) {
			parent = new int[size];
			rank = new int[size];
			nodeCount = new int[size];
		}

		public void makeSet() {

			for (int i = 0; i < parent.length; i++) {
				parent[i] = i;
				rank[i] = 0;
				nodeCount[i] = 1;
			}
		}

		public int find(int x) {

			if (parent[x] == x)
				return x;

			return parent[x] = find(parent[x]);
		}

		public void union(int x, int y) {

			x = find(x);
			y = find(y);

			if (x == y)
				return;

			if (rank[x] < rank[y]) {
				parent[x] = y;
				nodeCount[y] += nodeCount[x];
				nodeCount[x] = 1;
			}

			else if (rank[x] > rank[y]) {
				parent[y] = x;
				nodeCount[x] += nodeCount[y];
				nodeCount[y] = 1;
			}

			else {
				parent[y] = x;
				rank[x]++;
				nodeCount[x] += nodeCount[y];
				nodeCount[y] = 1;
			}
		}

		public int getGroupCount() {

			HashSet<Integer> set = new HashSet<>();

			for (int i = 0; i < parent.length; i++) {
				set.add(find(i));
			}

			return set.size();
		}

		public int getMaxGroup() {

			int max = 0;
			for (int i = 0; i < nodeCount.length; i++) {
				max = Math.max(max, nodeCount[i]);
			}

			return max;
		}
	}

}
