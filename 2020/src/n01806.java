import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01806 {

	static int[] arr;
	static int N, S;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		S = Integer.parseInt(s[1]);

		s = br.readLine().split(" ");
		arr = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(s[i]);

		bw.write(getMinLength(arr) + "\n");
		bw.flush();

	}

	public static int getMinLength(int[] arr) {
		int start = 0;
		int end = 0;
		int sum = 0;
		int len = N + 1;

		while (start < N) {

			if (sum >= S) {
				len = Math.min(len, end - start);
				sum -= arr[start++];
			} else if (end == N)
				sum -= arr[start++];
			else
				sum += arr[end++];
		}
		
		if (len > N)
			len = 0;

		return len;

	}

}
