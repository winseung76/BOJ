import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class n01149_RGB°Å¸® {
	private static int[][] arr;
	private static int[][] min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		arr = new int[n][3];
		min = new int[n][3];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			st = new StringTokenizer(str, " ");
			int index = 0;
			while (st.hasMoreTokens()) {
				arr[i][index] = Integer.parseInt(st.nextToken());
				min[i][index] = -1;
				index++;
			}

		}
		int r = get_min(n - 1, 0);
		int g = get_min(n - 1, 1);
		int b = get_min(n - 1, 2);

		bw.write(Math.min(Math.min(r, g), b) + "\n");
		bw.flush();

	}

	public static int get_min(int n, int rgb) {
		int result;

		if (n == 0)
			return arr[n][rgb];

		int index1 = (rgb + 1) % 3;
		int index2 = (rgb + 2) % 3;

		if (min[n - 1][index1] != -1 && min[n - 1][index2] != -1)
			result = Math.min(min[n - 1][index1], min[n - 1][index2]);
		else
			result = Math.min(get_min(n - 1, index1), get_min(n - 1, index2));

		result += arr[n][rgb];
		min[n][rgb] = result;

		return min[n][rgb];
	}
}
