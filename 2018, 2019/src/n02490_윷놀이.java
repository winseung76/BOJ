import java.util.Scanner;

public class n02490_¿∑≥Ó¿Ã {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = { 'D', 'C', 'B', 'A', 'E' };

		for (int i = 0; i < 3; i++) {
			int count = 0;
			for (int j = 0; j < 4; j++) {
				int x = sc.nextInt();
				if (x == 1)
					count++;
			}
			System.out.println(arr[count]);
		}
	}
}
