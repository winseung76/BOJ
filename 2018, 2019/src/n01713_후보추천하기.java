import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class n01713_후보추천하기 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> list = new ArrayList<>();
		int[] arr = new int[101];

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		String[] s = br.readLine().split(" ");

		for (int i = 0; i < K; i++) {
			int n = Integer.parseInt(s[i]);

			if (!list.contains(n)) {
				if (list.size() >= N) {
					arr[list.get(0)] = 0;
					list.remove(0);
				}
				list.add(0, n);

			}
			arr[n]++;
			int index = list.indexOf(n);
			while (index < list.size() - 1 && arr[list.get(index + 1)] <= arr[n]) {
				Collections.swap(list, index, index + 1);
				index = list.indexOf(n);
			}

			/*
			 * for (int j = 0; j < list.size(); j++) bw.write(list.get(j) + " ");
			 * bw.write("\n");
			 */

		}

		Collections.sort(list);

		for (int i = 0; i < list.size(); i++)
			bw.write(list.get(i) + " ");
		bw.flush();

	}
}
