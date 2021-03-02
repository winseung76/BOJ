import java.util.Scanner;

public class n05585_°Å½º¸§µ· {
	public static void main(String[] args) {

		int price = new Scanner(System.in).nextInt();
		int change = 1000 - price;
		int count = 0;
		int coin = 500;
		for (int i = 0; i < 6; i++) {
			count += change / coin;
			change = change % coin;
			if (i % 2 == 0)
				coin = coin / 5;
			else
				coin = coin / 2;
		}
		System.out.println(count);
	}
}
