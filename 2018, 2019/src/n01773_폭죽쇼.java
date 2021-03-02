import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01773_ÆøÁ×¼î {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int C = Integer.parseInt(s[1]);
		boolean[] arr = new boolean[C + 1];

		for (int i = 0; i < N; i++) {
			int p = Integer.parseInt(br.readLine());
			int t = 1;
			while (t <= C) {
				if (t % p == 0 && !arr[t])
					arr[t] = true;
				t++;
			}
		}
		int cnt = 0;
		for (int i = 1; i <= C; i++) {
			if (arr[i])
				cnt++;
		}
		bw.write(cnt + "\n");
		bw.flush();
	}
}
