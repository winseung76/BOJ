import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10995 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2 * n; j++) {
				if (i % 2 == 0) {
					if (j % 2 == 0)
						bw.write("*");
					else
						bw.write(" ");
				} else {
					if (j % 2 == 0)
						bw.write(" ");
					else
						bw.write("*");
				}
			}
			bw.write("\n");
		}
		bw.flush();

	}

}
