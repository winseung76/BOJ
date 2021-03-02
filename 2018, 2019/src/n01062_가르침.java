import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01062_°¡¸£Ä§ {
	static int num, N, K;
	static boolean[] check = new boolean[26];
	static String[] remain;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);
		remain = new String[N];

		for (int i = 0; i < N; i++)
			remain[i] = br.readLine();

		if (K >= 5) {
			check['a' - 97] = true;
			check['c' - 97] = true;
			check['n' - 97] = true;
			check['t' - 97] = true;
			check['i' - 97] = true;

			rmchar(K - 5, 'a');
		}

		bw.write(num + "\n");
		bw.flush();
	}

	public static void rmchar(int r, char ch) {

		int res = 0;

		if (r <= 0) {

			for (int i = 0; i < N; i++) {
				boolean flag = true;

				for (int j = 0; j < remain[i].length(); j++) {
					char c = remain[i].charAt(j);
					if (!check[c - 97]) {
						flag = false;
						break;
					}
				}
				if (flag)
					res++;
			}
			num = Math.max(num, res);
			return;
		}

		for (int i = ch - 97; i < 26; i++) {
			char c = (char) (i + 97);

			if (!check[i]) {
				check[i] = true;
				rmchar(r - 1, c);
				check[i] = false;
			}
		}
	}
}
