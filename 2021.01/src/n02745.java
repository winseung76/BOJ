import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class n02745 {

	static String N;
	static int B;
	static HashMap<Character, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = sarr[0];
		B = Integer.parseInt(sarr[1]);

		int n = 10;
		for (char ch = 'A'; ch <= 'Z'; ch++)
			map.put(ch, n++);

		int idx = 0;
		int sum = 0;
		for (int i = N.length() - 1; i >= 0; i--) {
			char ch = N.charAt(i);

			if ('0' <= ch && ch <= '9')
				sum += (int) (ch - '0') * Math.pow(B, idx++);
			else
				sum += map.get(ch) * Math.pow(B, idx++);

		}
		bw.write(sum + "\n");
		bw.flush();

	}

}
