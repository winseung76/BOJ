import java.util.HashMap;
import java.util.Scanner;

public class n02998_8Áø¼ö {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> maps = new HashMap();
		maps.put("000", "0");
		maps.put("001", "1");
		maps.put("010", "2");
		maps.put("011", "3");
		maps.put("100", "4");
		maps.put("101", "5");
		maps.put("110", "6");
		maps.put("111", "7");

		String s = sc.nextLine();
		while (s.length() % 3 != 0) {
			s = "0" + s;
		}
		for (int i = 0; i < s.length() / 3; i++) {
			String token = s.substring(3 * i, 3 * i + 3);
			System.out.print(maps.get(token));
		}
	}
}
