import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10775 {

	static boolean[] arr;
	static int cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());

		arr = new boolean[G + 1];

		boolean stop = false;
		for (int i = 0; i < P; i++) {
			int n = Integer.parseInt(br.readLine());

			if (!stop) {
				boolean flag = false;
				for (int j = n; j >= 1; j--) {
					if (!arr[j]) {
						arr[j] = true;
						flag = true;
						cnt++;
						break;
					}
				}
				if (!flag)
					stop = true;
			}
		}
		bw.write(cnt + "\n");
		bw.flush();

	}

}
