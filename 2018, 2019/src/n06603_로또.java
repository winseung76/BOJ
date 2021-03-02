import java.util.Scanner;

public class n06603_·Î¶Ç {
	private static int K;
	private static int[] arr;
	private static boolean[] isvisited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			K = sc.nextInt();
			if (K == 0)
				break;

			arr = new int[K];
			isvisited = new boolean[K];

			for (int i = 0; i < K; i++)
				arr[i] = sc.nextInt();

			StringBuffer buf;
			for (int i = 0; i < K; i++) {
				buf = new StringBuffer();
				dfs(i, 1, buf);
			}
			System.out.println();
		}

	}

	public static void dfs(int i, int cnt, StringBuffer buf) {

		StringBuffer buf2 = new StringBuffer();
		buf2.append(buf.toString() + arr[i] + " ");

		if (cnt == 6) {
			System.out.println(buf2.toString());
			return;
		}

		for (int j = i + 1; j < K; j++) {
			dfs(j, cnt + 1, buf2);
		}
	}
}
