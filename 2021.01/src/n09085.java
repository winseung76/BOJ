import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n09085 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			String[] sarr = br.readLine().split(" ");
			int sum = 0;
			for (int j = 0; j < N; j++) {
				sum += Integer.parseInt(sarr[j]);
			}
			bw.write(sum + "\n");
		}
		bw.flush();

	}

}
