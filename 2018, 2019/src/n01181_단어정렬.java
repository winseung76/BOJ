import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class n01181_단어정렬 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(br.readLine());
		HashMap pair = new HashMap<Integer, TreeSet>();
		TreeSet treeSet;

		for (int i = 0; i < size; i++) {
			String str = br.readLine();

			treeSet = (TreeSet) pair.get(str.length());
			if (treeSet == null) {
				treeSet = new TreeSet();
				pair.put(str.length(), treeSet);
			}
			treeSet.add(str);
		}
		for (int k = 1; k <= 50; k++) {
			treeSet = (TreeSet) pair.get(k);
			if (treeSet != null) {
				Iterator it = treeSet.iterator();
				while (it.hasNext()) {
					bw.write(it.next() + "\n");
					bw.flush();
				}
			}
		}
	}
}
