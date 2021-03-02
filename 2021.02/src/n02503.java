import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 로직을 어떻게 짜야할지 어려움
public class n02503 {

	static int N;
	static boolean[] arr = new boolean[1000];
	static Pair[] game;
	static int res;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		game = new Pair[N];

		for (int i = 0; i < N; i++) {
			String[] sarr = br.readLine().split(" ");

			String str = sarr[0];
			int s = Integer.parseInt(sarr[1]);
			int b = Integer.parseInt(sarr[2]);

			game[i] = new Pair(str, s, b);

		}
		int cnt = solve();

		bw.write(cnt + "\n");
		bw.flush();

	}

	public static int solve() {

		int cnt = 0;

		for (int n = 111; n < 1000; n++) { // 100부터 999까지 하나씩 검사

			String ans = String.valueOf(n);

			char fst = ans.charAt(0);
			char scd = ans.charAt(1);
			char trd = ans.charAt(2);

			if (!ans.contains("0") && (fst != scd && scd != trd && trd != fst)) {

				boolean flag = true;

				for (int i = 0; i < N; i++) {
					Pair pair = game[i]; // 영수가 제시한 숫자
					int s = 0;
					int b = 0;

					boolean[] check = new boolean[3];

					for (int idx = 0; idx < 3; idx++) {

						if (ans.charAt(idx) == pair.str.charAt(idx)) {
							s++;
							check[idx] = true;
						}
					}

					for (int idx = 0; idx < 3; idx++) {

						char ch = pair.str.charAt(idx);

						if (ch != ans.charAt(idx)) {
							int idx1 = (idx + 1) % 3;
							int idx2 = (idx + 2) % 3;

							if (!check[idx1] && ch == ans.charAt(idx1)) {
								b++;
								check[idx1] = true;
							} else if (!check[idx2] && ch == ans.charAt(idx2)) {
								b++;
								check[idx2] = true;
							}
						}

					}
					if (pair.s != s || pair.b != b)
						flag = false;
				}
				if (flag)
					cnt++;
			}
		}

		return cnt;

	}

	static class Pair {

		String str;
		int s, b;

		Pair(String str, int s, int b) {
			this.str = str;
			this.s = s;
			this.b = b;
		}
	}
}
