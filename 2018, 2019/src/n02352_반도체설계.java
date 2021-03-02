import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class n02352_반도체설계 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n];
		int[] port = new int[n];

		int result = 0;
		StringBuffer buf = new StringBuffer();
		buf.append(br.readLine());
		st = new StringTokenizer(buf.toString());

		for (int i = 0; i < n; i++) {
			port[i] = Integer.parseInt(st.nextToken());
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (port[j] < port[i])
					max = Math.max(max, dp[j]);
			}
			dp[i] = max + 1;
			result = Math.max(result, dp[i]);
		}
		bw.write(result + "\n");
		bw.flush();

	}
}
