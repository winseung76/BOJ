import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02525 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		int A = Integer.parseInt(sarr[0]);
		int B = Integer.parseInt(sarr[1]);
		int C = Integer.parseInt(br.readLine());

		int sum = B + C;
		int hour = 0;
		int minute = 0;

		if (sum >= 60) {
			minute = sum % 60;
			hour = A + sum / 60;
			if (hour >= 24)
				hour = hour - 24;
		} else {
			minute = sum;
			hour = A;
		}

		bw.write(hour + " " + minute + "\n");
		bw.flush();

	}

}
