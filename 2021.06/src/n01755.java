import java.io.*;
import java.util.*;

public class n01755 {

	static int M, N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");

		M = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);

		List<Pair> list = new ArrayList<>();

		for (int i = M; i <= N; i++) {
			String s = String.valueOf(i);
			StringBuilder sb = new StringBuilder();

			for (int j = 0; j < s.length(); j++) {
				char ch = s.charAt(j);
				if (j < s.length() - 1)
					sb.append(parseNum(ch) + " ");
				else
					sb.append(parseNum(ch));
			}

			list.add(new Pair(i, sb.toString()));
		}

		Collections.sort(list);

		int cnt = 0;
		for (Pair p : list) {

			bw.write(p.n + " ");
			cnt++;

			if (cnt == 10) {
				cnt = 0;
				bw.write("\n");
			}

		}
		bw.flush();

	}

	public static String parseNum(char ch) {

		if (ch == '0')
			return "zero";
		if (ch == '1')
			return "one";
		if (ch == '2')
			return "two";
		if (ch == '3')
			return "three";
		if (ch == '4')
			return "four";
		if (ch == '5')
			return "five";
		if (ch == '6')
			return "six";
		if (ch == '7')
			return "seven";
		if (ch == '8')
			return "eight";

		return "nine";
	}

	static class Pair implements Comparable<Pair> {

		int n;
		String str;

		Pair(int n, String str) {
			this.n = n;
			this.str = str;
		}

		@Override
		public int compareTo(Pair o) {

			return str.compareTo(o.str);
		}
	}

}
