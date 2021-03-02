import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

public class n02981_°Ë¹® {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> tmp = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		TreeSet<Integer> set = new TreeSet<>();

		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(br.readLine()));
		}
		Iterator it = set.iterator();
		while (it.hasNext()) {
			list.add((Integer) it.next());
		}

		Collections.sort(list);
		set.clear();

		for (int i = 0; i < list.get(0); i++) {
			tmp.clear();
			tmp.addAll(list);

			for (int j = 0; j < tmp.size(); j++)
				tmp.set(j, tmp.get(j) - i);

			while (true) {
				int k = 0;
				while (k < tmp.size()) {
					if (tmp.get(k) == 0)
						tmp.remove(k);
					else
						k++;
				}
				if (tmp.size() <= 1) {
					if (tmp.get(0) > 1)
						set.add(tmp.get(0));
					break;
				}

				int min = tmp.get(0);
				for (k = 1; k < tmp.size(); k++) {
					int rest = tmp.get(k) % min;
					tmp.set(k, rest);
				}
				Collections.sort(tmp);
				System.out.print("size : " + tmp.size() + "   ");
				for (k = 0; k < tmp.size(); k++)
					System.out.print(tmp.get(k) + " ");
				System.out.println();
			}

		}

		it = set.iterator();
		while (it.hasNext()) {
			bw.write(it.next() + " ");
		}
		bw.write("\n");
		bw.flush();

	}
}
