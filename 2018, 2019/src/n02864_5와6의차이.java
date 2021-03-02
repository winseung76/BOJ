import java.util.Scanner;

public class n02864_5와6의차이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String first = sc.next();
		String second = sc.next();

		int min = Integer.parseInt(first.replace('6', '5')) + Integer.parseInt(second.replace('6', '5'));
		int max = Integer.parseInt(first.replace('5', '6')) + Integer.parseInt(second.replace('5', '6'));

		System.out.println(min + " " + max);
	}
}
