import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n04796 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int i = 1;

		while (true) {

			String[] s = br.readLine().split(" ");

			int L = Integer.parseInt(s[0]);
			int P = Integer.parseInt(s[1]);
			int V = Integer.parseInt(s[2]);

			if (L == 0 && P == 0 && V == 0)
				break;

			int a = V / P;
			int b = V % P;

			int res = a * L;

			if (b >= L)
				res += L;
			else
				res += b;

			bw.write("Case " + i + ": " + res + "\n");
			i++;
		}
		bw.flush();
	}

}
