import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n07568 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		int[] rank = new int[N];

		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(s[0]);
			arr[i][1] = Integer.parseInt(s[1]);
			rank[i] = 1;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j) {
					if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1])
						rank[i]++;
				}
			}
		}
		for (int i = 0; i < N; i++)
			bw.write(rank[i] + " ");

		bw.write("\n");
		bw.flush();

	}
}
