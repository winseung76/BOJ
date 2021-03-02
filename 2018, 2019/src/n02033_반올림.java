import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02033_¹Ý¿Ã¸² {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int a = 10;

		while (n > a) {
			int b = n % a / (a / 10);

			if (b >= 5)
				n = n + a - b * (a / 10);
			else
				n = n - b * (a / 10);

			a *= 10;
		}
		bw.write(n + "\n");
		bw.flush();
	}
}
