import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01439 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String S = br.readLine();

		int zeroCnt = 0;
		int oneCnt = 0;
		int preN = 0;

		for (int i = 0; i < S.length(); i++) {
			int n = S.charAt(i) - '0';
			
			if (i == 0) {
				if (n == 0)
					zeroCnt++;
				else if (n == 1)
					oneCnt++;
			} else {
				if (n == 0 && preN == 1)
					zeroCnt++;
				else if (n == 1 && preN == 0)
					oneCnt++;
			}

			preN = n;
		}

		bw.write(Math.min(zeroCnt, oneCnt) + "\n");
		bw.flush();

	}

}
