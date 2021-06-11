import java.io.*;

public class n04880 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {

			String[] input = br.readLine().split(" ");
			int a1 = Integer.parseInt(input[0]);
			int a2 = Integer.parseInt(input[1]);
			int a3 = Integer.parseInt(input[2]);

			if (a1 == 0 && a2 == 0 && a3 == 0)
				break;

			if (a1 + a3 == 2 * a2)
				bw.write("AP " + (a3 + (a3 - a2)) + "\n");
			else if (a1 * a3 == a2 * a2)
				bw.write("GP " + (a3 * (a3 / a2)) + "\n");

		}
		bw.flush();

	}

}
