import java.io.*;
import java.util.*;

public class n01644 {

	static int N;
	static boolean[] prime = new boolean[4000000];
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < prime.length; i++)
			prime[i] = true;

		for (int n = 2; n * n < prime.length; n++) {
			if (prime[n]) {
				for (int i = 2; n * i < prime.length; i++) {
					prime[n * i] = false;
				}
			}
		}

		for (int i = 2; i < prime.length; i++) {
			if (prime[i])
				list.add(i);
		}

		bw.write(solve(list) + "\n");
		bw.flush();

	}

	public static int solve(List<Integer> list) {

		int s = 0, e = 0;
		int sum = 0;
		int cnt = 0;

		while (s < list.size()) {

			if (sum == N) {
				cnt++;
				sum -= list.get(s++);
			}

			else if (sum > N || e == list.size())
				sum -= list.get(s++);

			else
				sum += list.get(e++);
		}

		return cnt;

	}

}
