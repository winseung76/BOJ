import java.util.Scanner;

public class n01057_토너먼트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int kim = sc.nextInt();
		int im = sc.nextInt();
		int round = 1;
		while (N > 1) {
			kim = (int) Math.ceil(kim / 2.0);
			im = (int) Math.ceil(im / 2.0);
			if (kim == im)
				break;
			N = N / 2;
			round++;

		}
		System.out.println(round);

	}
}
