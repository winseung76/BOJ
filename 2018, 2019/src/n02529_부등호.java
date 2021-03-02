import java.util.Scanner;

public class n02529_∫ŒµÓ»£ {
	private static StringBuffer buf = new StringBuffer();
	private static boolean[] check;
	private static int K;
	private static String max = "0";
	private static String min = String.valueOf(Long.MAX_VALUE);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		K = sc.nextInt();

		for (int i = 0; i < K; i++)
			buf.append(sc.next());

		for (int i = 0; i < 10; i++) {
			check = new boolean[10];
			StringBuffer buff = new StringBuffer();
			dfs(i, 0, buff);
		}
		System.out.println(max);
		System.out.println(min);

	}

	public static void dfs(int n, int idx, StringBuffer sb) {

		StringBuffer tmp_buf = new StringBuffer();
		tmp_buf.append(sb.toString() + (char) (n + '0'));
		check[n] = true;

		if (idx > K - 1) {
			if (Long.parseLong(max) < Long.parseLong(tmp_buf.toString()))
				max = tmp_buf.toString();
			if (Long.parseLong(min) > Long.parseLong(tmp_buf.toString()))
				min = tmp_buf.toString();

			check[n] = false;
			return;
		}

		char c = buf.charAt(idx);
		if (c == '<') {
			for (int i = n + 1; i < 10; i++) {
				if (!check[i]) {
					dfs(i, idx + 1, tmp_buf);
				}
			}
		} else if (c == '>') {
			for (int i = 0; i < n; i++) {
				if (!check[i]) {
					dfs(i, idx + 1, tmp_buf);
				}
			}
		}
		check[n] = false;

	}
}
