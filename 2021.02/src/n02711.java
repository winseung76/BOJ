import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02711 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String[] sarr = br.readLine().split(" ");

			int n = Integer.parseInt(sarr[0]);
			String str = sarr[1];

			str = str.substring(0, n - 1) + str.substring(n);
			bw.write(str + "\n");
		}
		bw.flush();

	}

}
