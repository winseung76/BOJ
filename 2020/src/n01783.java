import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01783 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");

		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int res = 0;

		if (N == 1 || M == 1)
			res = 1;
		else if (N < 3 && M <= 6)
			res = (M - 1) / 2 + 1;
		else if (N < 3 && M > 6)
			res = 4;
		else if (N >= 3 && M <= 6) {
			if (M < 4)
				res = M;
			else
				res = 4;
		} else if (N >= 3 && M > 6)
			res = M - 2;

		bw.write(res + "\n");
		bw.flush();

	}

}
