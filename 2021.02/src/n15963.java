import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n15963 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		long N = Long.parseLong(sarr[0]);
		long M = Long.parseLong(sarr[1]);

		bw.write((N == M ? 1 : 0) + "\n");
		bw.flush();

	}

}
