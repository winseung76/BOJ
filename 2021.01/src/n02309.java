import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Vector;

public class n02309 {

	static int[] arr = new int[9];
	static Vector<Integer> list = new Vector<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		findDwarf(0, 0);

		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i) + "\n");
		}
		bw.flush();

	}

	public static boolean findDwarf(int idx, int sum) {

		if (list.size() == 7) {
			if (sum == 100)
				return true;
			return false;
		}

		for (int i = idx; i < 9; i++) {
			if (!list.contains(arr[i])) {
				list.add(arr[i]);
				sum += arr[i];

				if (findDwarf(i + 1, sum))
					return true;

				list.remove((Integer) arr[i]);
				sum -= arr[i];

			}
		}
		return false;

	}

}
