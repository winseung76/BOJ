import java.io.*;
import java.util.*;

public class n18108 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int diff = 2562 - 2019;

		int y = Integer.parseInt(br.readLine());

		bw.write((y - diff) + "\n");
		bw.flush();

	}

}
