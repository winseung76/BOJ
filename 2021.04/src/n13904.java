import java.io.*;
import java.util.*;

public class n13904 {

	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		List<Homework> list = new ArrayList<>();
		int maxDay = 0;

		for (int i = 0; i < N; i++) {

			String[] input = br.readLine().split(" ");

			int d = Integer.parseInt(input[0]);
			int w = Integer.parseInt(input[1]);

			list.add(new Homework(d, w));
			maxDay = Math.max(maxDay, d);
		}

		int sum = 0;

		for (int i = maxDay; i >= 1; i--) {

			Homework ans = new Homework(0, 0);

			for (Homework hw : list) {
				if (hw.d >= i) {
					if (ans.w < hw.w) {
						ans = hw;
					}
				}
			}

			sum += ans.w;
			list.remove(ans);
		}

		bw.write(sum + "\n");
		bw.flush();

	}

	static class Homework {

		int d, w;

		Homework(int d, int w) {
			this.d = d;
			this.w = w;
		}

	}

}
