import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10953 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String[] sarr = br.readLine().split(",");
			int a = Integer.parseInt(sarr[0]);
			int b = Integer.parseInt(sarr[1]);
			bw.write(a + b + "\n");
		}
		bw.flush();

	}

}
