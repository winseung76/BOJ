import java.util.Scanner;

public class n01120_¹®ÀÚ¿­ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String x = sc.next();
		String y = sc.next();

		int count = 0;
		int min = 0;
		for (int i = 0; i <= y.length() - x.length(); i++) {
			count = 0;
			for (int j = 0; j < x.length(); j++) {

				if (x.charAt(j) != y.charAt(j + i))
					count++;
			}
			if (i == 0)
				min = count;
			else
				min = Math.min(min, count);
		}
		System.out.println(min);

	}
}
