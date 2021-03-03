import java.io.*;
import java.util.*;

public class n09375 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {

			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();

			for (int i = 0; i < n; i++) {
				String[] sarr = br.readLine().split(" ");

				map.computeIfAbsent(sarr[1], key -> new Integer(0));
				map.put(sarr[1], map.get(sarr[1]) + 1);
			}

			int cnt = 1;
			for (String name : map.keySet()) {
				cnt *= (map.get(name) + 1);
			}
			cnt -= 1;

			bw.write(cnt + "\n");
		}

		bw.flush();
	}
}
