import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01259 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str;
		while (!(str = br.readLine()).equals("0")) {

			boolean flag = false;
			for (int i = 0; i < str.length() / 2; i++) {
				if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
					flag = true;
					break;
				}
			}
			if (flag)
				bw.write("no\n");
			else
				bw.write("yes\n");
		}
		bw.flush();

	}

}
