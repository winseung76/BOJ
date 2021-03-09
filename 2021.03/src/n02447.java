import java.io.*;

public class n02447 {

	static int N;
	static StringBuffer[] bufs;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		bufs = new StringBuffer[N];
		for (int i = 0; i < N; i++)
			bufs[i] = new StringBuffer();

		printRect(0, 0, N, false);

		for (int i = 0; i < N; i++)
			bw.write(bufs[i].toString() + "\n");

		bw.flush();

	}

	public static void printRect(int r, int c, int size, boolean center) {

		if (size == 3) {
			if (!center) {
				bufs[r].append("***");
				bufs[r + 1].append("* *");
				bufs[r + 2].append("***");
			} else {
				bufs[r].append("   ");
				bufs[r + 1].append("   ");
				bufs[r + 2].append("   ");
			}
			return;
		}

		for (int i = r; i < r + size; i += size / 3) {
			for (int j = c; j < c + size; j += size / 3) {
				if (i == r + size / 3 && j == c + size / 3)
					printRect(i, j, size / 3, true);
				else
					printRect(i, j, size / 3, center);
			}
		}

	}

}
