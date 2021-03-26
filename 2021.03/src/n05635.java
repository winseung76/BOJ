import java.io.*;

public class n05635 {

	static int n;
	static Info[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		arr = new Info[n];

		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			String name = input[0];
			int date = Integer.parseInt(input[1]);
			int month = Integer.parseInt(input[2]);
			int year = Integer.parseInt(input[3]);

			Info info = new Info(name, date, month, year);
			arr[i] = info;
		}

		mergeSort(0, n - 1);

		bw.write(arr[n - 1].name + "\n");
		bw.write(arr[0].name + "\n");
		bw.flush();

	}

	public static void mergeSort(int left, int right) {

		if (left < right) {

			int center = (left + right) / 2;

			mergeSort(left, center);
			mergeSort(center + 1, right);

			int size = center - left + 1;
			Info[] buf = new Info[size];

			for (int i = left; i <= center; i++)
				buf[i - left] = arr[i];

			int pl = 0;
			int pr = center + 1;
			int k = left;

			while (pl < size && pr <= right)
				arr[k++] = (buf[pl].compareTo(arr[pr]) < 0) ? buf[pl++] : arr[pr++];

			while (pl < size)
				arr[k++] = buf[pl++];

		}
	}

	static class Info implements Comparable<Info> {

		String name;
		int date, month, year;

		Info(String name, int date, int month, int year) {
			this.name = name;
			this.date = date;
			this.month = month;
			this.year = year;
		}

		@Override
		public int compareTo(Info o) {

			if (year == o.year) {

				if (month == o.month)
					return date - o.date;

				return month - o.month;
			}

			return year - o.year;
		}
	}

}
