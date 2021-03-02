import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10819 {

	static int N;
	static int[] A;
	static boolean[] visited;
	static int max;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		A = new int[N];
		visited = new boolean[N];

		String[] sarr = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(sarr[i]);

		for (int i = 0; i < N; i++) {
			visited[i] = true;
			comb(0, i);
			visited[i] = false;
		}

		bw.write(max + "\n");
		bw.flush();

	}

	public static void comb(int sum, int idx) {

		boolean flag = false;
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			max = Math.max(max, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb(sum + Math.abs(A[idx] - A[i]), i);
				visited[i] = false;
			}

		}

	}

}
