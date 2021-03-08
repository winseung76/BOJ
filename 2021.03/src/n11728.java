import java.io.*;
import java.util.Arrays;

public class n11728 {

	static int N, M;
	static int[] A, B;
	static int[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);

		A = new int[N];
		B = new int[M];
		arr = new int[N + M];

		sarr = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(sarr[i]);

		sarr = br.readLine().split(" ");
		for (int i = 0; i < M; i++)
			B[i] = Integer.parseInt(sarr[i]);

		Arrays.sort(A);
		Arrays.sort(B);
		mergeSort();

		for (int n : arr)
			bw.write(n + " ");
		bw.flush();

	}

	public static void mergeSort() {

		int pa = 0; // 배열 A를 가리키는 포인터 : 0
		int pb = 0; // 배열 B를 가리키는 포인터 : 0
		int k = 0;  // arr에 채워넣을 위치

		while (pa < N && pb < M)
			arr[k++] = (A[pa] < B[pb]) ? A[pa++] : B[pb++];

		while (pa < N)
			arr[k++] = A[pa++];

		while (pb < M)
			arr[k++] = B[pb++];

	}
}
