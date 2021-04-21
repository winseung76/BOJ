import java.io.*;
import java.util.*;

public class n11444 {

	static long N;
	static final int MOD = 1000000007;
	static HashMap<Long, Long> map = new HashMap<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Long.parseLong(br.readLine());

		long res = fib(N);

		bw.write(res + "\n");
		bw.flush();

	}

	public static long fib(long n) {

		if (n == 0)
			return 0;

		if (n == 1 || n == 2)
			return 1;

		if (map.containsKey(n))
			return map.get(n);

		if (n % 2 == 0) {
			long m = n / 2;
			long res1 = fib(m - 1);
			long res2 = fib(m);

			map.put(n, (2 * res1 % MOD + res2 % MOD) * res2 % MOD);

			return map.get(n);
		}

		else {
			long m = (n + 1) / 2;
			long res1 = fib(m - 1);
			long res2 = fib(m);

			map.put(n, (res1 * res1 % MOD + res2 * res2 % MOD) % MOD);

			return map.get(n);
		}

	}

}
