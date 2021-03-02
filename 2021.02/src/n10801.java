import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10801 {

	static int ACnt, BCnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		int[] a = new int[10];
		int[] b = new int[10];

		for (int i = 0; i < 10; i++)
			a[i] = Integer.parseInt(sarr[i]);

		sarr = br.readLine().split(" ");

		for (int i = 0; i < 10; i++)
			b[i] = Integer.parseInt(sarr[i]);

		for (int i = 0; i < 10; i++) {
			if (a[i] > b[i])
				ACnt++;
			else if (a[i] < b[i])
				BCnt++;
		}

		if (ACnt > BCnt)
			bw.write("A\n");
		else if (ACnt < BCnt)
			bw.write("B\n");
		else
			bw.write("D\n");
		bw.flush();

	}

}
