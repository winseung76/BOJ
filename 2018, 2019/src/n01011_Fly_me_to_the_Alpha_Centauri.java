import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class n01011_Fly_me_to_the_Alpha_Centauri {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		int count = 0;

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = y - x;
			count = 0;
			int k = 0;
			int[] arr = new int[3];
			while (d > 0) {
				arr[0] = k + 1;
				arr[1] = k;
				arr[2] = k - 1;

				for (int j = 0; j < 3; j++) {
					if (arr[j] > 0 && d - arr[j] >= (arr[j] - 1) * arr[j] / 2) {
						d = d - arr[j];
						k = arr[j];
						count++;
						break;
					}
				}

			}
			bw.write(count + "\n");
		}
		bw.flush();
	}

}
