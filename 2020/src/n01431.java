import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01431 {

	static String[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		arr = new String[N];

		for (int i = 0; i < N; i++) {

			String s = br.readLine();
			arr[i] = s;

		}
		mergeSort(arr, 0, N - 1);

		for (int i = 0; i < N; i++)
			bw.write(arr[i] + "\n");
		bw.flush();

	}

	public static int compare(String a, String b) {

		if (a.length() != b.length())
			return a.length() - b.length();

		int sum1 = 0, sum2 = 0;

		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			if ('0' <= c && c <= '9')
				sum1 += c - '0';
		}
		for (int i = 0; i < b.length(); i++) {
			char c = b.charAt(i);
			if ('0' <= c && c <= '9')
				sum2 += c - '0';
		}
		if (sum1 != sum2)
			return sum1 - sum2;

		return a.compareTo(b);
	}

	public static void mergeSort(String[] arr, int left, int right) {

		if (left < right) {
			int center = (left + right) / 2;

			mergeSort(arr, left, center);
			mergeSort(arr, center + 1, right);

			int size = center - left + 1;
			String[] buf = new String[size];

			for (int i = left; i <= center; i++)
				buf[i - left] = arr[i];

			int pl = 0, pr = center + 1;
			int k = left;

			while (pl < size && pr <= right)
				arr[k++] = (compare(buf[pl], arr[pr]) < 0) ? buf[pl++] : arr[pr++];

			while (pl < size)
				arr[k++] = buf[pl++];

		}
	}

}
