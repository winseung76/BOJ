import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01015 {

	static int[] arr;
	static int[] idx;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		idx = new int[N];
		String[] s = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(s[i]);
			arr[i] = n;
		}
	
		int k = 0;
		for (int i = 1; i <= 1000; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[j] == i) {
					idx[j] = k++;
				}
			}
		}
		for (int i = 0; i < N; i++)
			bw.write(idx[i] + " ");
		bw.flush();

	}
}
