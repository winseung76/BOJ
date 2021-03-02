import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class n01620 {

	static int N, M;
	static HashMap<String, Integer> map1 = new HashMap<>();
	static HashMap<Integer, String> map2 = new HashMap<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);

		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			map1.put(str, i);
			map2.put(i, str);
		}

		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if ('0' <= str.charAt(0) && str.charAt(0) <= '9')
				bw.write(map2.get(Integer.parseInt(str)) + "\n");
			else
				bw.write(map1.get(str) + "\n");
		}
		bw.flush();

	}

}
