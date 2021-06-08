import java.io.*;
import java.util.*;

public class n11023 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int sum = 0;
		for (int i = 0; i < input.length; i++) {
			sum += Integer.parseInt(input[i]);
		}

		bw.write(sum + "\n");
		bw.flush();

	}

}
