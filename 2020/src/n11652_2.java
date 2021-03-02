import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class n11652_2 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];

		for (int i = 0; i < N; i++)
			arr[i] = Long.parseLong(br.readLine());

		mergeSort(arr, 0, N - 1);

		long res = arr[0];
		int cnt = 1;
		int max = 1;

		for (int i = 1; i < N; i++) {
			if (arr[i] == arr[i - 1])
				cnt++;
			else {
				if (max < cnt) {
					max = cnt;
					res = arr[i - 1];
				} else if (max == cnt)
					res = Math.min(res, arr[i]);

				cnt = 1;
			}
		}
		
		if (max < cnt) {
			max = cnt;
			res = arr[N - 1];
		} else if (max == cnt)
			res = Math.min(res, arr[N - 1]);

		
		bw.write(res + "\n");
		bw.flush();

	}

	public static void mergeSort(long[] arr, int left, int right) {

		if (left < right) {

			int center = (left + right) / 2;

			mergeSort(arr, left, center);
			mergeSort(arr, center + 1, right);

			long[] buf = new long[center - left + 1];

			for (int i = left; i <= center; i++)
				buf[i - left] = arr[i];

			int pl = 0, pr = center + 1;
			int k = left;

			while (pl < buf.length && pr <= right)
				arr[k++] = (buf[pl] < arr[pr]) ? buf[pl++] : arr[pr++];

			while (pl < buf.length)
				arr[k++] = buf[pl++];
		}

	}

}
