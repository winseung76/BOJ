import java.io.*;
import java.util.*;

public class n02696 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int M = Integer.parseInt(br.readLine());
			List<Integer> res = new ArrayList<>();

			bw.write((M % 2 == 0 ? M / 2 : M / 2 + 1) + "\n");
			List<Integer> list = new ArrayList<>();

			if (M > 10) {

				int L = M / 10;
				for (int i = 0; i < L; i++) {
					list.add(10);
				}
				if (M % 10 != 0)
					list.add(M % 10);
			}

			else
				list.add(M);

			int cnt = 0;
			for (int j = 0; j < list.size(); j++) {
				String[] input = br.readLine().split(" ");

				for (int i = 0; i < list.get(j); i++) {

					res.add(Integer.parseInt(input[i]));

					if (i % 2 == 0) {

						Collections.sort(res);
						bw.write(res.get(res.size() / 2) + " ");

						cnt++;
					}
				}
				if (cnt == 10) {
					bw.write("\n");
					cnt = 0;
				}
			}
			bw.write("\n");

		}

		bw.flush();

	}

}
