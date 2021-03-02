import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01016 {

	static long min, max;
	static boolean[] check;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		min = Long.parseLong(s[0]);
		max = Long.parseLong(s[1]);

		int size = (int) (max - min + 1);
		check = new boolean[size];

		for (long i = 2; i * i <= max; i++) {
			long p = i * i;

			long start;
			if (min % p == 0)
				start = min / p;
			else
				start = min / p + 1;

			for (long j = start; p * j <= max; j++) {
				if (p * j - min >= 0)
					check[(int) (p * j - min)] = true;
			}
		}

		int cnt = 0;
		for (int i = 0; i < size; i++) {
			if (!check[i])
				cnt++;
		}
		bw.write(cnt + "\n");
		bw.flush();

	}

}
