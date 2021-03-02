import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class n01302 {

	static List<Pair> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			boolean flag = false;
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).name.equals(str)) {
					list.get(j).cnt++;
					flag = true;
				}
			}
			if (!flag)
				list.add(new Pair(str));
		}
		Pair[] arr = list.toArray(new Pair[list.size()]);
		mergeSort(arr, 0, arr.length - 1);

		bw.write(arr[arr.length - 1].name + "\n");
		bw.flush();

	}

	public static void mergeSort(Pair[] arr, int left, int right) {

		if (left < right) {

			int center = (left + right) / 2;

			mergeSort(arr, left, center);
			mergeSort(arr, center + 1, right);

			int size = center - left + 1;
			Pair[] buf = new Pair[size];

			for (int i = left; i <= center; i++)
				buf[i - left] = arr[i];

			int pl = 0, pr = center + 1;
			int k = left;

			while (pl < size && pr <= right)
				arr[k++] = (buf[pl].compareTo(arr[pr]) < 0) ? buf[pl++] : arr[pr++];

			while (pl < size)
				arr[k++] = buf[pl++];

		}
	}

	static class Pair implements Comparable<Pair> {

		String name;
		int cnt;

		Pair(String name) {
			this.name = name;
			this.cnt = 0;
		}

		@Override
		public int compareTo(Pair o) {

			if (cnt == o.cnt) {
				return o.name.compareTo(this.name);
			}
			return cnt - o.cnt;
		}
	}

}
