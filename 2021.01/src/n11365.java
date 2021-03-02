import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n11365 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str;
		while (!(str = br.readLine()).equals("END")) {

			for (int i = str.length() - 1; i >= 0; i--)
				bw.write(str.charAt(i));
			bw.write("\n");
		}
		bw.flush();
	}

}
