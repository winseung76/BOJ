import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n09610 {

	static int[] arr = new int[5];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String[] sarr = br.readLine().split(" ");
			int x = Integer.parseInt(sarr[0]);
			int y = Integer.parseInt(sarr[1]);

			if (x > 0 && y > 0)
				arr[1]++;
			else if (x > 0 && y < 0)
				arr[4]++;
			else if (x < 0 && y > 0)
				arr[2]++;
			else if (x < 0 && y < 0)
				arr[3]++;
			else
				arr[0]++;
		}

		bw.write("Q1: " + arr[1] + "\n");
		bw.write("Q2: " + arr[2] + "\n");
		bw.write("Q3: " + arr[3] + "\n");
		bw.write("Q4: " + arr[4] + "\n");
		bw.write("AXIS: " + arr[0] + "\n");
		bw.flush();

	}

}
