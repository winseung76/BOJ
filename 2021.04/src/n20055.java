import java.io.*;

public class n20055 {

	static int N, K;
	static int[] A;
	static int[][] num;
	static boolean[][] robot;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);

		num = new int[2][N + 1];
		robot = new boolean[2][N + 1];
		A = new int[2 * N + 1];

		input = br.readLine().split(" ");
		for (int i = 1; i <= 2 * N; i++) {
			A[i] = Integer.parseInt(input[i - 1]);
		}

		int n = 1;

		for (int i = 1; i <= N; i++)
			num[0][i] = n++;

		for (int i = N; i >= 1; i--)
			num[1][i] = n++;

		bw.write(solve() + "\n");
		bw.flush();

	}

	public static int solve() {

		int check = 0;

		while (checkDurability()) {

			moveBelt();
			moveRobot();
			loadRobot();
			check++;

		}

		return check;
	}

	public static boolean checkDurability() {

		int cnt = 0;

		for (int i = 1; i <= 2 * N; i++) {
			if (A[i] == 0)
				cnt++;
		}

		return cnt < K;
	}

	public static void loadRobot() {

		if (A[num[0][1]] > 0) { // 내구도가 0보다 크면 로봇이 올라감
			robot[0][1] = true;
			A[num[0][1]]--;
		}
	}

	public static void moveRobot() {

		for (int i = N - 1; i >= 1; i--) {

			if (robot[0][i] && !robot[0][i + 1] && A[num[0][i + 1]] > 0) {
				robot[0][i] = false;
				robot[0][i + 1] = true;
				A[num[0][i + 1]]--; // 내구도 감소
			}
		}

		robot[0][N] = false;

	}

	public static void moveBelt() {

		int tmp = num[1][1];

		for (int i = 1; i < N; i++) {
			num[1][i] = num[1][i + 1];
		}

		num[1][N] = num[0][N];

		for (int i = N; i >= 2; i--) {
			num[0][i] = num[0][i - 1];
			robot[0][i] = robot[0][i - 1];
		}

		num[0][1] = tmp;

		robot[0][1] = false;
		robot[0][N] = false;

	}
}
