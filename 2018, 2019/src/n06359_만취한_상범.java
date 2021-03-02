import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n06359_만취한_상범 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			int res = 0;
			int[] arr = new int[n + 1]; // 0 열려있음, 1 닫혀있음

			for (int i = 1; i <= n; i++) {
				int cnt = 0;
				for (int j = 2; j <= i; j++) {
					if (i % j == 0)
						cnt++;
				}
				if (cnt % 2 == 0)
					res++;
			}
			bw.write(res + "\n");
			bw.flush();
		}
	}
}
