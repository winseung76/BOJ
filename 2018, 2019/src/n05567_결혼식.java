import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


public class n05567_°áÈ¥½Ä {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		HashSet<Integer> f = new HashSet<>(); // friends
		HashSet<Integer> fof = new HashSet<>(); // friends of friends

		int m = sc.nextInt();

		Pair[] arr = new Pair[m];
		for (int i = 0; i < m; i++) {
			int tmp_a = sc.nextInt();
			int tmp_b = sc.nextInt();
			arr[i] = new Pair(Math.min(tmp_a, tmp_b), Math.max(tmp_a, tmp_b));
		}
		Arrays.sort(arr);

		for (int i = 0; i < m; i++) {
			if (arr[i].a == 1)
				f.add(arr[i].b);

			else if (f.contains(arr[i].a)) {
				if (!fof.contains(arr[i].b) && !f.contains(arr[i].b))
					fof.add(arr[i].b);
			} else if (f.contains(arr[i].b)) {
				if (!fof.contains(arr[i].a) && !f.contains(arr[i].a))
					fof.add(arr[i].a);
			}
		}
		System.out.println(f.size() + fof.size());
	}
}

class Pair implements Comparable {
	int a, b;

	Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public int compareTo(Object o) {
		return a - ((Pair) o).a;
	}
}
