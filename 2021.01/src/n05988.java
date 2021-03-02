import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n05988 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();

			int n = s.charAt(s.length() - 1) - '0';

			if (n % 2 == 0)
				bw.write("even\n");
			else
				bw.write("odd\n");

		}
		bw.flush();

	}

}
