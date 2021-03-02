import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02566 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int max = 0;
		int r = 0, c = 0;

		for (int i = 1; i <= 9; i++) {
			String[] sarr = br.readLine().split(" ");
			for (int j = 1; j <= 9; j++) {
				int n = Integer.parseInt(sarr[j - 1]);

				if (max < n) {
					max = n;
					r = i;
					c = j;
				}

			}
		}
		bw.write(max + "\n");
		bw.write(r + " " + c + "\n");
		bw.flush();

	}

}
