import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class n09076 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String[] sarr = br.readLine().split(" ");
			int[] arr = new int[5];
			for (int j = 0; j < 5; j++) {
				arr[j] = Integer.parseInt(sarr[j]);
			}
			Arrays.sort(arr);

			if (arr[3] - arr[1] >= 4)
				bw.write("KIN\n");
			else
				bw.write((arr[1] + arr[2] + arr[3]) + "\n");
		}

		bw.flush();

	}

}
