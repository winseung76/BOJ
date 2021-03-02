import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n15964 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		long A = Long.parseLong(sarr[0]);
		long B = Long.parseLong(sarr[1]);

		long res = (A + B) * (A - B);

		bw.write(res + "\n");
		bw.flush();

	}

}
