import java.util.Scanner;

public class n10798_세로읽기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] arr = new char[5][];
		for (int i = 0; i < 5; i++) {
			arr[i] = sc.nextLine().toCharArray();
		}
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if (arr[j].length > i)
					System.out.print(arr[j][i]);
			}
		}

	}
}
