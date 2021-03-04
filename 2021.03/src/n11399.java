import java.io.*;
import java.util.*;

public class n11399 {

	static int N;
	static int[] arr;
	static int res;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		String[] sarr = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(sarr[i]);

		Arrays.sort(arr);

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];
			res += sum;
		}

		bw.write(res + "\n");
		bw.flush();

	}

}
