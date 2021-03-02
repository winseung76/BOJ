import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n11943 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int min = Integer.MAX_VALUE;

		String[] sarr = br.readLine().split(" ");
		int A = Integer.parseInt(sarr[0]);
		int B = Integer.parseInt(sarr[1]);

		sarr = br.readLine().split(" ");
		int C = Integer.parseInt(sarr[0]);
		int D = Integer.parseInt(sarr[1]);

		min = Math.min(min, A + D);
		min = Math.min(min, B + C);

		bw.write(min + "\n");
		bw.flush();

	}

}
