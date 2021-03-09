import java.io.*;

public class n01992 {

	static int N;
	static int[][] arr;
	static StringBuffer buf = new StringBuffer();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		quardTree(0, 0, N);

		bw.write(buf.toString() + "\n");
		bw.flush();

	}

	public static void quardTree(int r, int c, int size) {

		if (size == 1) {
			if (arr[r][c] == 0)
				buf.append("0");
			else
				buf.append("1");

			return;
		}

		boolean flag = true;
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (arr[i][j] != arr[r][c]) {
					flag = false;
					break;
				}
			}
			if (!flag)
				break;
		}

		if (flag) {
			if (arr[r][c] == 0)
				buf.append("0");
			else
				buf.append("1");

			return;
		}

		buf.append("(");
		for (int i = r; i < r + size; i += size / 2) {
			for (int j = c; j < c + size; j += size / 2) {
				quardTree(i, j, size / 2);
			}
		}
		buf.append(")");
	}

}
