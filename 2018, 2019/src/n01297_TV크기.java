import java.util.Scanner;

public class n01297_TVÅ©±â {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double C = sc.nextDouble();
		double A = sc.nextDouble();
		double B = sc.nextDouble();
		double x;

		x = Math.sqrt(C * C / (A * A + B * B));

		System.out.println((int) (A * x) + " " + (int) (B * x));
	}
}
