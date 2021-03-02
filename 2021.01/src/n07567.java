import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n07567 {

	static int height;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();

		height = 10;

		for (int i = 1; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (str.charAt(i - 1) == ch)
				height += 5;
			else
				height += 10;

		}
		bw.write(height + "\n");
		bw.flush();

	}

}
