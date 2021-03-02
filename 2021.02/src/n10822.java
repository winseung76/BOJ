import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10822 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(",");

		long sum = 0;
		for (int i = 0; i < sarr.length; i++)
			sum += Integer.parseInt(sarr[i]);

		bw.write(sum + "\n");
		bw.flush();

	}

}
