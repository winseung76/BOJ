import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class n11652 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		HashMap<Long, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {

			long n = Long.parseLong(br.readLine());

			if (map.containsKey(n))
				map.put(n, map.get(n) + 1);
			else
				map.put(n, 1);

		}
		
		ArrayList<Pair> list = new ArrayList<>();
		
		Iterator<Long> it = map.keySet().iterator();
		
		while (it.hasNext()) {
			long n = it.next();
			list.add(new Pair(n, map.get(n)));
		}

		Object[] arr = list.toArray();
		int length = arr.length;
		mergeSort(arr, 0, length - 1);

		bw.write(((Pair) arr[length - 1]).n + "\n");
		bw.flush();

	}

	public static void mergeSort(Object[] arr, int left, int right) {

		if (left < right) {

			int center = (left + right) / 2;

			mergeSort(arr, left, center);
			mergeSort(arr, center + 1, right);

			Pair[] buf = new Pair[center - left + 1];

			for (int i = left; i <= center; i++)
				buf[i - left] = (Pair) arr[i];

			int pl = 0, pr = center + 1;
			int k = left;

			while (pl < buf.length && pr <= right)
				arr[k++] = (buf[pl].compareTo((Pair) arr[pr]) < 0) ? buf[pl++] : arr[pr++];

			while (pl < buf.length)
				arr[k++] = buf[pl++];
		}

	}

}

class Pair implements Comparable {
	long n;
	int cnt;

	Pair(long n, int cnt) {
		this.n = n;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Object o) {

		if (cnt == ((Pair) o).cnt) {
			if (((Pair) o).n > n)
				return 1;
			else if (((Pair) o).n < n)
				return -1;
			else
				return 0;
		}
		return cnt - ((Pair) o).cnt;
	}
}
