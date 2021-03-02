import java.util.Scanner;

public class n05532_¹æÇÐ¼÷Á¦ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int L = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		int math, korean;

		if (A % C != 0)
			korean = A / C + 1;
		else
			korean = A / C;

		if (B % D != 0)
			math = B / D + 1;
		else
			math = B / D;

		System.out.println(L - Math.max(math, korean));

	}
}
