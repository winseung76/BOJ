import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10103 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int chang = 100;
		int sang = 100;

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String[] sarr = br.readLine().split(" ");
			int a = Integer.parseInt(sarr[0]);
			int b = Integer.parseInt(sarr[1]);
			if (a < b)
				chang -= b;
			else if (a > b)
				sang -= a;
		}
		bw.write(chang + "\n" + sang + "\n");
		bw.flush();

	}

}
