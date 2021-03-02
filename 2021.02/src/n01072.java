import java.io.*;

public class n01072 {

	static long X, Y, Z;
	static long n;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		X = Integer.parseInt(sarr[0]);
		Y = Integer.parseInt(sarr[1]);
		Z = Y * 100 / X;

		if (Z >= 99)
			n = -1;
		else
			n = binSearch(0, X);

		bw.write(n + "\n");
		bw.flush();

	}

	public static long binSearch(long left, long right) {

		long pl = left;
		long pr = right;
		long res;

		do {

			long pc = (pl + pr) / 2;

			res = (Y + pc) * 100 / (X + pc);

			if (res == Z)
				pl = pc + 1;

			else if (res > Z)
				pr = pc - 1;

		} while (pl <= pr);

		return pl;
	}

}
