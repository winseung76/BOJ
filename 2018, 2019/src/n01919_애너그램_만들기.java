import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class n01919_애너그램_만들기 {
	public static void main(String[] args) {
		HashMap<Character, Integer> map = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		int count = 0;
		for (int i = 0; i < str1.length(); i++) {
			Character c = str1.charAt(i);
			if (str2.contains(c.toString())) {
				if (!map.containsKey(c))
					map.put(c, 0);
				map.put(c, map.get(c) + 1);
			} else
				count++;
		}
		for (int i = 0; i < str2.length(); i++) {
			char c = str2.charAt(i);
			if (map.containsKey(c))
				map.put(c, map.get(c) - 1);
			else
				count++;
		}
		Iterator it = map.keySet().iterator();

		while (it.hasNext()) {
			count += Math.abs(map.get(it.next()));
		}
		System.out.println(count);

	}
}
