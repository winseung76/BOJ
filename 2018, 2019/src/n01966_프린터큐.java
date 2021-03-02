import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class n01966_프린터큐 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> q;
		int[] priority;

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			int N = Integer.parseInt(s.split(" ")[0]);
			int M = Integer.parseInt(s.split(" ")[1]);
			String[] arr = br.readLine().split(" ");
			priority = new int[N];
			q = new LinkedList<>();

			int max = Integer.MIN_VALUE;

			for (int j = 0; j < N; j++) {
				q.offer(j);
				priority[j] = Integer.parseInt(arr[j]);
			}

			int count = 0;
			while (!q.isEmpty()) {
				int t = q.poll();

				Iterator it = q.iterator();
				max = Integer.MIN_VALUE;
				while (it.hasNext()) {
					int data = (int) it.next();
					max = Math.max(max, priority[data]);
				}
				if (priority[t] < max)
					q.offer(t);
				else {
					count++;
					if (t == M)
						break;
				}

			}
			bw.write(count + "\n");
			bw.flush();
		}

	}
}
