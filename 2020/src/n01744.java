import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 양수의 경우, 1을 다른 수와 곱하는 것보다 더하는 것이 더 큰값이 나옴
// 음수의 경우, 더하는 것보다 0과 곱하는 것이 더 큰 값이 나옴
public class n01744 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] pn = new int[N]; // 양수 배열
		int[] nn = new int[N]; // 음수 배열

		int a = 0, b = 0, cnt = 0;
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 1) // 1이 나오면 카운트한다
				cnt++;
			else if (n > 0)
				pn[a++] = n;
			else
				nn[b++] = n;
		}

		mergeSort(pn, 0, a - 1);
		mergeSort(nn, 0, b - 1);

		long res = 0;

		for (int i = 0; i < a;) {
			if (i == a - 1)
				res += pn[i++];
			else {
				res += pn[i] * pn[i + 1];
				i += 2;
			}
		}
		for (int i = 0; i < b;) {
			if (i == b - 1)
				res += nn[i++];
			else {
				res += nn[i] * nn[i + 1];
				i += 2;
			}
		}
		res += cnt;

		bw.write(res + "\n");
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

			int pl = 0, pr = center + 1;
			int k = left;

			while (pl < size && pr <= right)
				arr[k++] = (Math.abs(buf[pl]) > Math.abs(arr[pr])) ? buf[pl++] : arr[pr++];

			while (pl < size)
				arr[k++] = buf[pl++];

		}
	}

}
