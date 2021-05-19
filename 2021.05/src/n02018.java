import java.io.*;

public class n02018 {

	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		bw.write(solve() + "\n");
		bw.flush();

	}

	public static int solve() {

		int s = 1;
		int e = 1;
		int sum = 0;
		int cnt = 0;

		while (s <= N) {

			if (sum < N)
				sum += e++;
			else if (sum > N || e == N)
				sum -= s++;
			else {
				cnt++;
				sum -= s++;
			}
		}

		return cnt;

	}

}
