import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n05086 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {

			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);

			if (a == 0 && b == 0)
				break;

			if (a > b && a % b == 0)
				bw.write("multiple\n");
			else if (a < b && b % a == 0)
				bw.write("factor\n");
			else
				bw.write("neither\n");
		}
		bw.flush();

	}

}
