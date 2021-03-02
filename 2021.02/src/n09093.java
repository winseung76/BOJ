import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n09093 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String[] sarr = br.readLine().split(" ");
			for (int j = 0; j < sarr.length; j++) {
				String s = sarr[j];

				for (int k = s.length() - 1; k >= 0; k--) {
					bw.write(s.charAt(k));
				}
				bw.write(" ");
			}
			bw.write("\n");
		}

		bw.flush();

	}

}
