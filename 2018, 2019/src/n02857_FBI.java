import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02857_FBI {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = 0;
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();

			if (str.contains("FBI")) {
				bw.write(i + 1 + " ");
				count++;
			}
		}
		if (count == 0)
			bw.write("HE GOT AWAY!");
		bw.flush();
	}
}
