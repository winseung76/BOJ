import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10214 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int yonsei = 0;
			int korea = 0;
			for (int j = 0; j < 9; j++) {
				String[] sarr = br.readLine().split(" ");
				int Y = Integer.parseInt(sarr[0]);
				int K = Integer.parseInt(sarr[1]);

				if (Y > K)
					yonsei++;
				else if (Y < K)
					korea++;
			}

			if (yonsei > korea)
				bw.write("Yonsei\n");
			else if (yonsei < korea)
				bw.write("Korea\n");
			else
				bw.write("Draw\n");
		}
		bw.flush();

	}

}
