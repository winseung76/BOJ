import java.io.*;

public class n02023 {

	static int N;
	static boolean[] visited = new boolean[10];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		for (int i = 2; i <= 9; i++) {
			if (isPrime(i)) {
				dfs(new StringBuilder(i + ""));
			}
		}

	}

	public static void dfs(StringBuilder sb) {

		if (sb.length() == N) {
			System.out.println(sb.toString());
			return;
		}

		for (int i = 0; i <= 9; i++) {
			int n = Integer.parseInt(sb.toString()) * 10 + i;

			if (isPrime(n)) {
				sb.append(i + "");
				dfs(sb);
				sb.deleteCharAt(sb.length() - 1);
			}

		}

	}

	public static boolean isPrime(int n) {

		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

}
