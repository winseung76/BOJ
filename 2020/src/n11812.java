import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n11812 {

	static long N;
	static int K, Q;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");

		N = Long.parseLong(s[0]);
		K = Integer.parseInt(s[1]);
		Q = Integer.parseInt(s[2]);

		for (int i = 0; i < Q; i++) {
			s = br.readLine().split(" ");
			long a = Long.parseLong(s[0]);
			long b = Long.parseLong(s[1]);

			if (K == 1)
				bw.write(Math.abs(a - b) + "\n");
			else
				bw.write(getDist(a, b) + "\n");
		}
		bw.flush();

	}

	public static long getParent(long n) {

		return (n - 2) / K + 1;
	}

	public static long getDist(long a, long b) {

		long dist = 0;

		while (a != b) {
			if (a > b)
				a = getParent(a);
			else
				b = getParent(b);

			dist++;
		}

		return dist;
	}

}
