import java.util.HashMap;
import java.util.Scanner;

public class n01076_ÀúÇ× {
	public static void main(String[] args) {
		HashMap<String, Integer> color = new HashMap<>();
		color.put("black", 0);
		color.put("brown", 1);
		color.put("red", 2);
		color.put("orange", 3);
		color.put("yellow", 4);
		color.put("green", 5);
		color.put("blue", 6);
		color.put("violet", 7);
		color.put("grey", 8);
		color.put("white", 9);

		Scanner sc = new Scanner(System.in);

		long result = 0;

		result += color.get(sc.nextLine()) * 10;
		result += color.get(sc.nextLine());
		result *= Math.pow(10, color.get(sc.nextLine()));
		System.out.println(result);

	}
}
