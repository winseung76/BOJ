import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01547 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] arr = { 1, 2, 3 };

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			String[] sarr = br.readLine().split(" ");
			int X = Integer.parseInt(sarr[0]);
			int Y = Integer.parseInt(sarr[1]);

			int xidx = 0;
			int yidx = 0;
			for (int j = 0; j < 3; j++) {
				if (arr[j] == X)
					xidx = j;
				else if (arr[j] == Y)
					yidx = j;
			}

			int tmp = arr[xidx];
			arr[xidx] = arr[yidx];
			arr[yidx] = tmp;
		}
		bw.write(arr[0] + "\n");
		bw.flush();

	}

}
