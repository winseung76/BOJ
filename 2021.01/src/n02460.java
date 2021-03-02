import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02460 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int sum = 0;
		int max = 0;
		for (int i = 0; i < 10; i++) {
			String[] sarr = br.readLine().split(" ");
			int a = Integer.parseInt(sarr[0]);
			int b = Integer.parseInt(sarr[1]);

			sum = sum - a + b;
			max = Math.max(max, sum);
		}
		bw.write(max + "\n");
		bw.flush();

	}

}
