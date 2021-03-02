import java.util.Scanner;

public class n03053_택시기하학 {
	public static void main(String[] args) {
		int R = new Scanner(System.in).nextInt();

		double u = R * R * Math.PI;
		double t = 2 * R * R;

		System.out.println(String.format("%06f", u) + "\n" + String.format("%06f", t));

	}
}
