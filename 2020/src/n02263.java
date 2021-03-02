import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02263 {

	static int[] in, post;
	static int[] index;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {

		int n = Integer.parseInt(br.readLine());

		in = new int[n];
		post = new int[n];
		index = new int[n + 1];

		String[] s = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			int m = Integer.parseInt(s[i]);
			in[i] = m;
			index[m] = i;
		}

		s = br.readLine().split(" ");

		for (int i = 0; i < n; i++)
			post[i] = Integer.parseInt(s[i]);

		printPre(0, n - 1, 0, n - 1);

	}

	public static void printPre(int is, int ie, int ps, int pe) throws Exception {

		if (is > ie || ps > pe)
			return;

		int root = post[pe];
		bw.write(root + " ");
		bw.flush();

		int idx = index[root];
		int size = idx - is;

		printPre(is, idx - 1, ps, ps + size - 1);
		printPre(idx + 1, ie, ps + size, pe - 1);

	}
}
