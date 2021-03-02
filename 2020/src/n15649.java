import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Vector;

public class n15649 {

	static int N, M;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {

		String[] s = br.readLine().split(" ");

		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		for (int i = 1; i <= N; i++) {
			Vector<Integer> list = new Vector();
			dfs(list, i, 1);
		}

	}

	public static void dfs(Vector<Integer> list, int n, int cnt) throws Exception {

		list.add(n);

		if (cnt == M) {
			Iterator<Integer> it = list.iterator();
			while (it.hasNext()) {
				bw.write(it.next() + " ");
			}
			bw.write("\n");
			bw.flush();

			list.remove((Integer) n);
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!list.contains(i))
				dfs(list, i, cnt + 1);
		}

		list.remove((Integer) n);

	}

}
