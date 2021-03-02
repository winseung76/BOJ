import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class n05579_«·«ã«Ã«Õ«ë {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < 30; i++)
			list.add(i + 1);
		for (int i = 0; i < 28; i++) {
			list.remove((Object) sc.nextInt());
		}
		Collections.sort(list);
		System.out.println(list.get(0) + "\n" + list.get(1));

	}
}
