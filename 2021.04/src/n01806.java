import java.io.*;

public class n01806 {

	static int N, S;
	static int[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		S = Integer.parseInt(input[1]);

		arr = new int[N];

		input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		bw.write(solve() + "\n");
		bw.flush();

	}

	public static int solve() {

		int s = 0, e = 0;
		int sum = 0;
		int len = Integer.MAX_VALUE;

		while (s < arr.length) {

			if (sum >= S || e == arr.length) {
				if (sum >= S)
					len = Math.min(len, e - s);
				sum -= arr[s++];
			}

			else {
				sum += arr[e++];
			}
		}

		if (len == Integer.MAX_VALUE)
			len = 0;

		return len;
	}

}
