import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class n05525_IOIOI {

	static int[] pi;
	static int N, M;
	static char[] S, P;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		S = br.readLine().toCharArray();
		pi = new int[2 * N + 1];
		P = new char[2 * N + 1];
		int cnt = 0;

		for (int i = 0; i < 2 * N; i += 2) {
			P[i] = 'I';
			P[i + 1] = 'O';
		}
		P[2 * N] = 'I';

		getPi();

		int begin = 0, m = 0;
		while (begin <= S.length - P.length) {
			if (m < P.length && S[begin + m] == P[m]) {
				m++;
				if (m == P.length)
					cnt++;
			} else {
				if (m == 0)
					begin++;
				else {
					begin += (m - pi[m - 1]);
					m = pi[m - 1];
				}
			}
		}
		bw.write(cnt + "\n");
		bw.flush();
	}

	static void getPi() {

		int begin = 1, m = 0;

		while (begin + m < P.length) {
			if (P[begin + m] == P[m]) {
				m++;
				pi[begin + m - 1] = m;
			} else {
				if (m == 0)
					begin++;
				else {
					begin += m - pi[m - 1];
					m = pi[m - 1];
				}
			}
		}
	}
}
