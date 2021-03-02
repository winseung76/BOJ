import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class n02605 {

	static Vector<Integer> list = new Vector<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String[] sarr = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(sarr[i - 1]);
			list.add(n, i);
		}

		for (int i = list.size() - 1; i >= 0; i--)
			bw.write(list.get(i) + " ");
		bw.flush();

	}

}
