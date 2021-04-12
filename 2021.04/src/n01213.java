import java.io.*;
import java.util.*;

public class n01213 {

	static TreeMap<Character, Integer> map = new TreeMap<>(Collections.reverseOrder());

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			map.computeIfAbsent(ch, key -> new Integer(0));
			map.replace(ch, map.get(ch) + 1);
		}

		Set<Character> set = map.keySet();
		Iterator<Character> it = set.iterator();

		if (str.length() % 2 == 0) {

			while (it.hasNext()) {
				char ch = it.next();

				if (map.get(ch) % 2 != 0) {
					bw.write("I'm Sorry Hansoo");
					bw.flush();
					return;
				}
			}
		}

		else {
			int cnt = 0;
			while (it.hasNext()) {
				char ch = it.next();

				if (map.get(ch) % 2 != 0) {
					if (cnt == 1) {
						bw.write("I'm Sorry Hansoo");
						bw.flush();
						return;
					}
					cnt++;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		char center = '0';
		it = set.iterator();

		while (it.hasNext()) {
			char ch = it.next();

			if (map.get(ch) % 2 != 0)
				center = ch;

			for (int i = 0; i < map.get(ch) / 2; i++) {
				sb.insert(0, ch);
				sb.append(ch);
			}
		}

		if (center != '0')
			sb.insert(sb.length() / 2, center);

		bw.write(sb.toString() + "\n");
		bw.flush();

	}

}
