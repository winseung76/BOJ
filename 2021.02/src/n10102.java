import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10102 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int V = Integer.parseInt(br.readLine());

		String str = br.readLine();

		int cnt1 = 0, cnt2 = 0;

		for (int i = 0; i < V; i++) {
			if (str.charAt(i) == 'A')
				cnt1++;
			else if (str.charAt(i) == 'B')
				cnt2++;
		}

		if (cnt1 > cnt2)
			bw.write("A\n");
		else if (cnt1 < cnt2)
			bw.write("B\n");
		else
			bw.write("Tie\n");
		bw.flush();
	}

}
