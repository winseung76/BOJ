import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n04256 {

	static int T;
	static int[] pre, in, post;
	static int idx;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());

			pre = new int[n];
			in = new int[n];
			post = new int[n];
			idx = n - 1;

			String[] s = br.readLine().split(" ");
			for (int i = 0; i < n; i++)
				pre[i] = Integer.parseInt(s[i]);

			s = br.readLine().split(" ");
			for (int i = 0; i < n; i++)
				in[i] = Integer.parseInt(s[i]);

			postOrder(n, 0, n - 1, 0, n - 1);

			for (int i = 0; i < n; i++)
				bw.write(post[i] + " ");
			bw.write("\n");

		}
		bw.flush();

	}

	public static void postOrder(int size, int ps, int pe, int is, int ie) {

		if (idx < 0)
			return;

		if (ps <= pe && is <= ie) {
			//System.out.println(ps + " " + pe + " " + is + " " + ie + "  " + pre[ps]);
			post[idx--] = pre[ps];

			for (int i = 0; i <= ie - is; i++) {
				if (in[is + i] == pre[ps]) {
					postOrder(size, ps + i + 1, pe, is + i + 1, ie);
					postOrder(size, ps + 1, ps + i, is, is + i - 1);
					break;
				}
			}
		}
	}

}
