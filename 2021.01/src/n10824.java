import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10824 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		String a = sarr[0];
		String b = sarr[1];
		String c = sarr[2];
		String d = sarr[3];

		long A = Long.parseLong(a + b);
		long B = Long.parseLong(c + d);

		bw.write(A + B + "\n");
		bw.flush();

	}

}
