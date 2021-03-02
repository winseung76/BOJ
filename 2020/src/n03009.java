import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n03009 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		int x1 = Integer.parseInt(s[0]);
		int y1 = Integer.parseInt(s[1]);

		s = br.readLine().split(" ");
		int x2 = Integer.parseInt(s[0]);
		int y2 = Integer.parseInt(s[1]);

		s = br.readLine().split(" ");
		int x3 = Integer.parseInt(s[0]);
		int y3 = Integer.parseInt(s[1]);

		int x4, y4;
		if (x1 == x2)
			x4 = x3;
		else if (x1 == x3)
			x4 = x2;
		else
			x4 = x1;

		if (y1 == y2)
			y4 = y3;
		else if (y1 == y3)
			y4 = y2;
		else
			y4 = y1;

		bw.write(x4 + " " + y4 + "\n");
		bw.flush();

	}

}
