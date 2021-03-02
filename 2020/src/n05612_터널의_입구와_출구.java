import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n05612_터널의_입구와_출구 {

	static int max;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		max = m;

		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			int in = Integer.parseInt(s[0]);
			int out = Integer.parseInt(s[1]);

			m = in + m - out;

			if (m < 0) {
				max = 0;
				break;
			}

			max = Math.max(max, m);
		}

		bw.write(max + "\n");
		bw.flush();
	}
}
