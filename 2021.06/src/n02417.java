import java.io.*;
import java.util.*;

public class n02417 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long n = Long.parseLong(br.readLine());
		double d = Math.sqrt(n);

		bw.write(binSearch(d) + "\n");
		bw.flush();

	}

	public static long binSearch(double d) {

		long pl = 0;
		long pr = Long.MAX_VALUE;

		do {

			long pc = (pl + pr) / 2;

			if (pc == d)
				return pc;

			if (d < pc)
				pr = pc - 1;
			else
				pl = pc + 1;

		} while (pl <= pr);

		return pl;
	}

}
