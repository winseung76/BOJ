import java.util.ArrayList;
import java.util.Scanner;

public class n10828_Ω∫≈√ {
	private static int size;
	private static Stack stack = new Stack();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String cmd;

		size = sc.nextInt();

		for (int i = 0; i < size; i++) {
			cmd = sc.next();

			switch (cmd) {
			case "push":
				int data = sc.nextInt();
				stack.push(data);
				break;
			case "pop":
				System.out.println(stack.pop());
				break;
			case "size":
				System.out.println(stack.getSize());
				break;
			case "empty":
				System.out.println(stack.isEmpty() ? 1 : 0);
				break;
			case "top":
				System.out.println(stack.peek());
				break;
			}
		}

	}

	static class Stack {

		private ArrayList database = new ArrayList();
		private int top = -1;

		public void push(int data) {
			database.add(data);
			top++;
		}

		public int pop() {

			if (getSize() > 0) {
				int data = (int) database.get(top);
				database.remove(top);
				top--;

				return data;
			} else
				return -1;

		}

		public boolean isEmpty() {
			if (getSize() == 0)
				return true;
			else
				return false;
		}

		public int peek() {

			if (getSize() > 0) {
				return (int) database.get(top);
			} else
				return -1;
		}

		public int getSize() {
			return database.size();
		}
	}
}
