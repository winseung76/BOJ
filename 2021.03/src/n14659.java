import java.io.*;

public class n14659 {

	static int N;
	static int[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		String[] sarr = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(sarr[i]);

		int max = 0;

		for (int i = 0; i < N; i++) {
			int h = arr[i];
			int cnt = 0;
			for (int j = i + 1; j < N; j++) {
				if (arr[j] >= h)
					break;
				cnt++;
			}
			max = Math.max(max, cnt);
		}

		bw.write(max + "\n");
		bw.flush();
	}

}
