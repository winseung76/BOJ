import java.io.*;
import java.util.*;

public class n18870 {

	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		int[] arr2 = new int[N];
		HashSet<Integer> set = new HashSet<>();

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
			arr2[i] = arr[i];
		}

		mergeSort(arr2, 0, N - 1);

		HashMap<Integer, Integer> map = new HashMap<>();

		int idx = 0;
		for (int n : arr2) {
			if (!map.containsKey(n))
				map.put(n, idx++);

		}

		for (int i = 0; i < N; i++)
			bw.write(map.get(arr[i]) + " ");

		bw.flush();

	}

	public static void mergeSort(int[] arr, int left, int right) {

		if (left < right) {

			int center = (left + right) / 2;

			mergeSort(arr, left, center);
			mergeSort(arr, center + 1, right);

			int size = center - left + 1;

			int[] buf = new int[size];

			for (int i = left; i <= center; i++)
				buf[i - left] = arr[i];

			int pl = 0;
			int pr = center + 1;
			int k = left;

			while (pl < size && pr <= right)
				arr[k++] = (buf[pl] < arr[pr]) ? buf[pl++] : arr[pr++];

			while (pl < size)
				arr[k++] = buf[pl++];

		}
	}

}
