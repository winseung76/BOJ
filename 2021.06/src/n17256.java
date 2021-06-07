import java.io.*;

public class n17256 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int ax = Integer.parseInt(input[0]);
		int ay = Integer.parseInt(input[1]);
		int az = Integer.parseInt(input[2]);

		input = br.readLine().split(" ");
		int cx = Integer.parseInt(input[0]);
		int cy = Integer.parseInt(input[1]);
		int cz = Integer.parseInt(input[2]);

		int bx = cx - az;
		int by = cy / ay;
		int bz = cz - ax;

		bw.write(bx + " " + by + " " + bz);
		bw.flush();

	}

}
