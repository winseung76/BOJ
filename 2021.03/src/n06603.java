import java.io.*;
import java.util.*;

public class n06603 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {

			String[] sarr = br.readLine().split(" ");
			int k = Integer.parseInt(sarr[0]);

			if (k == 0)
				break;

			int[] S = new int[sarr.length - 1];
			for (int i = 0; i < S.length; i++)
				S[i] = Integer.parseInt(sarr[i + 1]);

			List<Integer> list = new ArrayList<>();
			comb(S, 0, list);
			System.out.println();
		}

	}

	public static void comb(int[] S, int idx, List<Integer> list) {

		if (list.size() == 6) {
			for (int n : list)
				System.out.print(n + " ");
			System.out.println();
			return;
		}

		for (int i = idx; i < S.length; i++) {
			list.add(S[i]);
			comb(S, i + 1, list);
			list.remove(list.size() - 1);
		}
	}
}
