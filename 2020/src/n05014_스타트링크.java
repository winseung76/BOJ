import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class n05014_스타트링크 {
	static int F, S, G, U, D;
	static int[] move;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] arr = br.readLine().split(" ");
		F = Integer.parseInt(arr[0]);
		S = Integer.parseInt(arr[1]);
		G = Integer.parseInt(arr[2]);
		U = Integer.parseInt(arr[3]);
		D = Integer.parseInt(arr[4]);

		move = new int[F + 1];

		for (int i = 1; i <= F; i++)
			move[i] = Integer.MAX_VALUE;

		int res = elevator();
		if (res == -1)
			bw.write("use the stairs\n");
		else
			bw.write(res + "\n");
		bw.flush();
	}

	public static int elevator() {

		Queue<Integer> q = new LinkedList<>();

		q.add(S);
		move[S] = 0;

		while (!q.isEmpty()) {
			int n = q.poll();

			if (n == G)
				return move[n];

			if (n + U <= F && move[n + U] > move[n] + 1) {
				q.add(n + U);
				move[n + U] = move[n] + 1;
			}
			if (n - D >= 1 && move[n - D] > move[n] + 1) {
				q.add(n - D);
				move[n - D] = move[n] + 1;
			}
		}
		return -1;
	}
}
