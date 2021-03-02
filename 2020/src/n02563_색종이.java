import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02563_»öÁ¾ÀÌ {

	static int[][] map = new int[100][100];
	static int res;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {

			String[] s = br.readLine().split(" ");
			int l = Integer.parseInt(s[0]);
			int r = Integer.parseInt(s[1]);

			for (int x = l; x < l + 10; x++) {
				for (int y = r; y < r + 10; y++) {
					map[y][x] = 1;
				}
			}
		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1)
					res++;
			}
		}
		bw.write(res + "\n");
		bw.flush();
	}

}
