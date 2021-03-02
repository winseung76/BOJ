import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02828_사과담기게임 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] a = br.readLine().split(" ");
		int N = Integer.parseInt(a[0]);
		int M = Integer.parseInt(a[1]);
		int J = Integer.parseInt(br.readLine());

		int pos = 1;
		int move = 0;
		for (int i = 0; i < J; i++) {
			int n = Integer.parseInt(br.readLine());
			while (true) {
				if (pos <= n && n < pos + M)
					break;
				move++;
				if (pos < n)
					pos++;
				else if (pos > n)
					pos--;
			}
		}

		bw.write(move + "\n");
		bw.flush();
	}
}
