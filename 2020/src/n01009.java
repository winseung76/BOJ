import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class n01009 {

	static Vector<Integer>[] list = new Vector[10];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < 10; i++)
			list[i] = new Vector();

		list[1].add(1);

		list[2].add(6);
		list[2].add(2);
		list[2].add(4);
		list[2].add(8);

		list[3].add(1);
		list[3].add(3);
		list[3].add(9);
		list[3].add(7);

		list[4].add(6);
		list[4].add(4);

		list[5].add(5);

		list[6].add(6);

		list[7].add(1);
		list[7].add(7);
		list[7].add(9);
		list[7].add(3);

		list[8].add(6);
		list[8].add(8);
		list[8].add(4);
		list[8].add(2);

		list[9].add(1);
		list[9].add(9);

		for (int i = 0; i < T; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]) % 10;
			int b = Integer.parseInt(s[1]);

			if (a == 0)
				bw.write(10 + "\n");
			else {
				int size = list[a].size();
				bw.write(list[a].get((b % size)) + "\n");
			}

		}
		bw.flush();

	}
}
