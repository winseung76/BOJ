import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class n15652 {

	static int N, M;
	static Vector<Integer> list = new Vector<>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);

		comb(1,0);
		bw.flush();

	}

	public static void comb(int n, int cnt) throws Exception {

		if (cnt == M) {
			for (int i = 0; i < list.size(); i++)
				bw.write(list.get(i) + " ");
			bw.write("\n");

			return;
		}

		for (int i = n; i <= N; i++) {
			list.add(i);
			comb(i, cnt + 1);
			list.remove(list.size() - 1);
		}
	}

}
