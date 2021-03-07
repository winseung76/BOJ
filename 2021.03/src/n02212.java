import java.io.*;
import java.util.*;

public class n02212 {

	static int N, K;
	static int[] arr;
	static List<Integer> dist = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		arr = new int[N];
		String[] sarr = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(sarr[i]);

		Arrays.sort(arr);

		for (int i = 0; i < N - 1; i++) {
			int d = arr[i + 1] - arr[i];
			if (d > 0)
				dist.add(d);
		}
		Collections.sort(dist, Collections.reverseOrder());
		int cnt = 0;
		while (dist.size() > 0 && cnt < K - 1) {
			dist.remove(0);
			cnt++;
		}

		int sum = 0;
		for (int n : dist)
			sum += n;

		bw.write(sum + "\n");
		bw.flush();

	}

}
