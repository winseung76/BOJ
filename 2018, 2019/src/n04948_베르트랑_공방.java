import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n04948_베르트랑_공방 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n, count = 0;
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			count = 0;
			if (n == 1 || n == 2)
				count = 1;
			else {
				for (int i = n + 1; i < 2 * n; i++) {
					int j;
					for (j = 2; j <= Math.sqrt(i); j++) {
						if (i % j == 0)
							break;
					}
					if (j > Math.sqrt(i))
						count++;
				}
			}
			bw.write(count + "\n");
			bw.flush();
		}
	}
}
