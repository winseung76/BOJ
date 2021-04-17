import java.io.*;
import java.util.*;

public class n02153 {

	static int[] arr;
	static HashMap<Character, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char ch = 'a';
		for (int i = 1; i <= 26; i++) {
			map.put(ch, i);
			ch = (char) (ch + 1);
		}
		ch = 'A';
		for (int i = 27; i <= 52; i++) {
			map.put(ch, i);
			ch = (char) (ch + 1);
		}

		int n = 0;
		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			n += map.get(c);
		}

		boolean prime = true;
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				prime = false;
				break;
			}
		}

		if (prime)
			bw.write("It is a prime word.");
		else
			bw.write("It is not a prime word.");

		bw.flush();

	}

}
