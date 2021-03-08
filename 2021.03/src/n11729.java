import java.io.*;

public class n11729 {

	static int N;
	static int cnt;
	static StringBuffer buf = new StringBuffer();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		hanoiTower(1, 3, N);

		bw.write(cnt + "\n");
		bw.write(buf.toString() + "\n");
		bw.flush();

	}

	public static void hanoiTower(int src, int dst, int n) {

		if (n == 1) {
			buf.append(src + " " + dst + "\n");
			cnt++;
			return;
		}

		int tmp;

		if (src == 1 && dst == 2)
			tmp = 3;
		else if (src == 1 && dst == 3)
			tmp = 2;
		else if (src == 2 && dst == 1)
			tmp = 3;
		else if (src == 2 && dst == 3)
			tmp = 1;
		else if (src == 3 && dst == 1)
			tmp = 2;
		else
			tmp = 1;

		hanoiTower(src, tmp, n - 1);
		hanoiTower(src, dst, 1);
		hanoiTower(tmp, dst, n - 1);

	}

}
