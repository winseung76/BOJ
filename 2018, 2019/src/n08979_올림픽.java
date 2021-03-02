import java.util.Arrays;
import java.util.Scanner;

public class n08979_¿Ã¸²ÇÈ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Medal[] arr = new Medal[N];
		int K = sc.nextInt();

		for (int i = 0; i < N; i++)
			arr[i] = new Medal(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());

		Arrays.sort(arr);

		int i = 0;
		int rank = 1;
		int count = 1;
		while (true) {
			if (i > 0) {
				if (arr[i].gold != arr[i - 1].gold || arr[i].silver != arr[i - 1].silver
						|| arr[i].copper != arr[i - 1].copper) {
					rank += count;
					count = 1;
				} else
					count++;
			}
			if (arr[i].number == K)
				break;
			i++;
		}

		System.out.println(rank);
	}
}

class Medal implements Comparable {
	int number;
	int gold;
	int silver;
	int copper;

	Medal(int number, int gold, int silver, int copper) {
		this.number = number;
		this.gold = gold;
		this.silver = silver;
		this.copper = copper;
	}

	@Override
	public int compareTo(Object o) {
		if (gold < ((Medal) o).gold)
			return 1;
		else if (gold == ((Medal) o).gold) {
			if (silver < ((Medal) o).silver)
				return 1;
			else if (silver == ((Medal) o).silver) {
				return ((Medal) o).copper - copper;
			} else
				return -1;
		} else
			return -1;
	}
}