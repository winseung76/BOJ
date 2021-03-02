import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class n01786_Ã£±â {

	static int[] pi;
	static char[] t, p;
	static List<Integer> lst = new ArrayList<>();
	static int res;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String T = br.readLine();
		String P = br.readLine();

		pi = new int[P.length()];
		p = P.toCharArray();
		t = T.toCharArray();

		getPi();

		int begin = 0, cnt = 0;
		while (begin <= t.length - p.length) {
			if (cnt < p.length && t[begin + cnt] == p[cnt]) {
				cnt++;
				if (cnt == p.length) {
					lst.add(begin + 1);
					res++;
				}
			} else {
				if (cnt == 0)
					begin++;
				else {
					begin += (cnt - pi[cnt - 1]);
					cnt = pi[cnt - 1];
				}
			}
		}
		bw.write(res + "\n");
		for (int i = 0; i < lst.size(); i++)
			bw.write(lst.get(i) + " ");

		bw.flush();
	}

	static void getPi() {

		int begin = 1, cnt = 0;

		while (begin + cnt < p.length) {
			if (p[begin + cnt] == p[cnt]) {
				cnt++;
				pi[begin + cnt - 1] = cnt;
			} else {
				if (cnt == 0)
					begin++;
				else {
					begin += (cnt - pi[cnt - 1]);
					cnt = pi[cnt - 1];
				}
			}
		}
	}
}
