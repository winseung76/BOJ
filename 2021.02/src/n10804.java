import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10804 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] arr = new int[21];
		for (int i = 1; i <= 20; i++)
			arr[i] = i;

		for (int i = 0; i < 10; i++) {
			String[] sarr = br.readLine().split(" ");
			int s = Integer.parseInt(sarr[0]);
			int e = Integer.parseInt(sarr[1]);

			for (int j = s; j <= (s + e) / 2; j++) {
				int tmp = arr[j];
				arr[j] = arr[s + e - j];
				arr[s + e - j] = tmp;
			}

		}

		for (int i = 1; i <= 20; i++)
			bw.write(arr[i] + " ");
		bw.flush();

	}

}
