import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01701_Cubeditor {

	static char[] S;
	static int[] pi;
	static int max;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();

		for (int st = 0; st < s.length(); st++) {
			String str = s.substring(st);
			S = str.toCharArray();
			pi = new int[S.length];

			getPi(S);

			for (int i = pi.length - 1; i >= 0; i--) {
				if (pi[i] >= 2 && max < pi[i])
					max = pi[i];
			}
		}
		bw.write(max + "\n");
		bw.flush();

		return;
	}

	static void getPi(char[] p) {

		int begin = 1, m = 0;

		while (begin + m < p.length) {

			if (p[begin + m] == p[m]) {
				m++;
				pi[begin + m - 1] = m;
			} else {
				if (m == 0)
					begin++;
				else {
					begin += (m - pi[m - 1]);
					m = pi[m - 1];
				}
			}
		}
	}
}
