import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02512 {

	static int[] arr;
	static int N, M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		int sum = 0;
		int max = 0;

		String[] s = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(s[i]);
			sum += arr[i];
			max = Math.max(max, arr[i]);
		}

		M = Integer.parseInt(br.readLine());

		if (sum <= M)
			bw.write(max + "\n");
		else {
			int start = M / N;
			bw.write(binSearch(start, max) + "\n");
		}
		bw.flush();

	}

	public static int binSearch(int s, int e) {

		int pl = s;
		int pr = e;
		int pc = 0;

		do {
			pc = (pl + pr) / 2;

			int sum = 0;
			for (int i = 0; i < N; i++)
				sum += Math.min(arr[i], pc);

			if (sum <= M) {
				pl = pc + 1;
			} else
				pr = pc - 1;

		} while (pl <= pr);

		return pr;
	}

}
