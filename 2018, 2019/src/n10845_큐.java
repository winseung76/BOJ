import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n10845_ť {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			String s = sc.next();

			switch (s) {
			case "push":
				int n = sc.nextInt();
				q.offer(n);
				break;
			case "pop":
				if (q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(q.poll());
				break;
			case "size":
				System.out.println(q.size());
				break;
			case "empty":
				System.out.println(q.isEmpty() ? 1 : 0);
				break;
			case "front":
				if (q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(q.peek());
				break;
			case "back":
				if (q.isEmpty())
					System.out.println(-1);
				else {
					Iterator it = q.iterator();
					int back = 0;
					while (it.hasNext()) {
						back = (int) it.next();
					}
					System.out.println(back);
				}
				break;
			}

		}

	}
}
