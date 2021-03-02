import java.util.Arrays;
import java.util.Scanner;

public class n01371_가장많은글자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Pair[] arr = new Pair[26];

		for (int i = 0; i < 26; i++)
			arr[i] = new Pair((char) ('a' + i), 0);

		while (sc.hasNextLine()) {
			String s = sc.nextLine();

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
					arr[s.charAt(i) - 97].count++;
			}
		}
		Arrays.sort(arr);
		int max = arr[arr.length - 1].count;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].count == max)
				System.out.print(arr[i].alph);
		}

	}

	static class Pair implements Comparable {
		int count = 0;
		char alph;

		Pair(char alph, int count) {
			this.alph = alph;
			this.count = count;
		}

		@Override
		public int compareTo(Object o) {
			return count - ((Pair) o).count;
		}
	}
}
