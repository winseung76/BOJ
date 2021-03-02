import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02669 {

	static boolean[][] board = new boolean[101][101];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 4; i++) {
			String[] sarr = br.readLine().split(" ");

			int x1 = Integer.parseInt(sarr[0]);
			int y1 = Integer.parseInt(sarr[1]);
			int x2 = Integer.parseInt(sarr[2]);
			int y2 = Integer.parseInt(sarr[3]);

			for (int x = x1; x < x2; x++) {
				for (int y = y1; y < y2; y++) {
					board[x][y] = true;
				}
			}
		}
		int sum = 0;

		for (int x = 1; x <= 100; x++) {
			for (int y = 1; y <= 100; y++) {
				if (board[x][y])
					sum++;
			}
		}

		bw.write(sum + "\n");
		bw.flush();

	}

}
