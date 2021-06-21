import java.io.*;
import java.util.*;

public class n01864 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		HashMap<Character, Integer> map = new HashMap<>();
		map.put('-', 0);
		map.put('\\', 1);
		map.put('(', 2);
		map.put('@', 3);
		map.put('?', 4);
		map.put('>', 5);
		map.put('&', 6);
		map.put('%', 7);
		map.put('/', -1);

		String str = "";

		while (!(str = br.readLine()).equals("#")) {

			int n = 1;
			int res = 0;

			for (int i = str.length() - 1; i >= 0; i--) {
				char ch = str.charAt(i);
				res += map.get(ch) * n;
				n *= 8;
			}

			bw.write(res + "\n");

		}
		bw.flush();

	}

}
