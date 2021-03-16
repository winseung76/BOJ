import java.io.*;

public class n10972 {

	static int N;
	static int[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		String[] sarr = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(sarr[i]);
		}

		boolean flag = false;

		for (int i = N - 1; i >= 1; i--) {
			if (arr[i] > arr[i - 1]) {

				for (int j = N - 1; j >= i; j--) {
					if (arr[i - 1] < arr[j]) {
						swap(i - 1, j);
						int s = i;
						int e = N - 1;
						while (s < e) {
							swap(s, e);
							s++;
							e--;
						}
						flag = true;
						break;
					}
				}

			}
			if (flag)
				break;
		}

		if (flag) {
			for (int n : arr)
				bw.write(n + " ");

			bw.write("\n");
		}

		else
			bw.write(-1 + "\n");

		bw.flush();
	}

	public static void swap(int a, int b) {

		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

}
