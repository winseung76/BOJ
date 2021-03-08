import java.io.*;

public class n01780 {

	static int N;
	static int[][] paper;
	static int[] arr = new int[3]; // arr[0] : -1인 종이의 개수, arr[1] : 0인 종이의 개수, arr[2] : 1인 종이의 개수

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] sarr = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(sarr[j]);
			}
		}

		solve(0, 0, N);

		bw.write(arr[0] + "\n");
		bw.write(arr[1] + "\n");
		bw.write(arr[2] + "\n");
		bw.flush();

	}

	public static void solve(int r, int c, int size) {

		if (size == 1) { // base case 1
			if (paper[r][c] == -1)
				arr[0]++;
			else if (paper[r][c] == 0)
				arr[1]++;
			else if (paper[r][c] == 1)
				arr[2]++;
			return;
		}

		int idx = checkAllSame(r, c, size);
		if (idx < 3) {  // base case 2
			arr[idx]++;
			return;
		}

		for (int i = r; i < r + size; i += size / 3) {
			for (int j = c; j < c + size; j += size / 3) {
				solve(i, j, size / 3);
			}
		}

	}

	public static int checkAllSame(int r, int c, int size) {

		boolean flag = true; // 모두 같은 수를 가짐 flase : 하나라도 다른 수가 있다

		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (paper[i][j] != paper[r][c]) {
					flag = false;
					break;
				}
			}
			if (!flag)
				break;
		}

		if (!flag)
			return 3;

		if (paper[r][c] == -1)
			return 0;

		if (paper[r][c] == 0)
			return 1;

		return 2;

	}
}
