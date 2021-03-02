import java.util.Scanner;
import java.util.TreeMap;

public class n01159_³ó±¸°æ±â {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeMap<Character, Integer> map = new TreeMap<>();
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			String s = sc.next();
			char c = s.charAt(0);

			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else
				map.put(c, 1);
		}
		int count = 0;
		for (char ch : map.keySet()) {
			if (map.get(ch) >= 5) {
				System.out.print(ch);
				count++;
			}
		}
		if (count == 0)
			System.out.println("PREDAJA");
	}
}
