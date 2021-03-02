import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01568 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int rest = N;
		int n = 1;
		int cnt = 0;

		while (rest > 0) {

			if (rest < n)
				n = 1;

			rest -= n;
			cnt++;
			n++;
		}

		bw.write(cnt + "\n");
		bw.flush();

	}

}
