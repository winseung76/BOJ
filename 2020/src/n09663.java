import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n09663 {

	static int N;
	static int[] arr;
	static int res;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[0] = i;
			dfs(1);
		}
		bw.write(res + "\n");
		bw.flush();
	}

	public static void dfs(int row) {

		if (row >= N)
			res++;

		else {
			for (int i = 0; i < N; i++) {
				arr[row] = i;

				if (isPossible(row)) {
					dfs(row + 1);
				}
			}
		}
	}

	public static boolean isPossible(int r) {

		for (int i = 0; i < r; i++) {
			if (arr[i] == arr[r])
				return false;
			if (Math.abs(r - i) == Math.abs(arr[r] - arr[i]))
				return false;
		}

		return true;
	}
}