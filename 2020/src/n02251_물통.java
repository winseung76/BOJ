import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class n02251_물통 {

	static int[] size = new int[3];
	static boolean[] res;
	static boolean[][][] check = new boolean[201][201][201];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] arr = br.readLine().split(" ");
		for (int i = 0; i < 3; i++)
			size[i] = Integer.parseInt(arr[i]);

		res = new boolean[size[2] + 1];

		bfs(new Pair(new int[] { 0, 0, size[2] }));

		for (int i = 0; i < res.length; i++) {
			if (res[i])
				bw.write(i + " ");
		}
		bw.flush();

	}

	static void bfs(Pair pair) {

		Queue<Pair> q = new LinkedList<>();
		int[] nw = new int[3];

		q.add(pair);
		check[pair.w[0]][pair.w[1]][pair.w[2]] = true;

		while (!q.isEmpty()) {

			Pair p = q.poll();
	
			if (p.w[0] == 0)
				res[p.w[2]] = true;

			for (int i = 0; i < 3; i++) {

				if (p.w[i] > 0) {

					for (int j = 1; j <= 2; j++) {

						nw[0] = p.w[0];
						nw[1] = p.w[1];
						nw[2] = p.w[2];

						int idx = (i + j) % 3; // 물을 받는 물통

						if (p.w[idx] < size[idx]) {
							int mv = Math.min(size[idx] - p.w[idx], p.w[i]);
							nw[idx] += mv;
							nw[i] -= mv;

							if (!check[nw[0]][nw[1]][nw[2]]) {
								q.add(new Pair(new int[] { nw[0], nw[1], nw[2] }));
								check[nw[0]][nw[1]][nw[2]] = true;
							}
						}
					}
				}
			}
		}
	}

	static class Pair {
		int[] w;// 물통 물의 양

		Pair(int[] water) {
			this.w = water;
		}
	}
}
