import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class n01759 {

	static int L, C;
	static char[] arr;
	static boolean[] check;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		L = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);

		arr = new char[C];
		check = new boolean[C];

		s = br.readLine().split(" ");
		for (int i = 0; i < C; i++) {
			arr[i] = s[i].charAt(0);
		}

		Arrays.sort(arr);

		StringBuffer buf = new StringBuffer();

		getPwd(0, buf, 0);

	}

	public static void getPwd(int cnt, StringBuffer buf, int idx) throws Exception {

		if (cnt == L) {

			int vowed = 0;
			int cons = 0;

			for (int i = 0; i < buf.length(); i++) {

				if ("aeiou".contains(buf.subSequence(i, i + 1)))
					vowed++;
				else
					cons++;
			}
			if (vowed >= 1 && cons >= 2) {
				bw.write(buf.toString() + "\n");
				bw.flush();
				return;
			}

			return;
		}

		for (int i = idx; i < C; i++) {
			if (!check[i]) {
				check[i] = true;
				buf.append(arr[i]);
				getPwd(cnt + 1, buf, i + 1);
				buf.delete(cnt, buf.length());
				check[i] = false;
			}
		}

	}

}
