import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class n14425_2 {

	static HashSet<String> set = new HashSet<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			set.add(str);
		}
		int cnt = 0;

		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (set.contains(str))
				cnt++;
		}
		bw.write(cnt + "\n");
		bw.flush();

	}

}
