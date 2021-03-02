import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.Vector;

public class n01325 {

	static int N, M;
	static Vector<Integer>[] arr;
	static int[] indegree;
	static boolean[] visited;
	static int[] count;
	static int max;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		indegree = new int[N + 1];
		count = new int[N + 1];
		arr = new Vector[N + 1];
		for (int i = 1; i <= N; i++)
			arr[i] = new Vector();

		for (int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			int A = Integer.parseInt(s[0]);
			int B = Integer.parseInt(s[1]);

			arr[A].add(B);
			indegree[A]++;
		}

		for (int i = 1; i <= N; i++) {
			//if (indegree[i] == 0) {
				visited = new boolean[N + 1];
				dfs(i);
				//max = Math.max(max, count[i]);
			//}
		}
		for(int i=1;i<=N;i++) {
			if(max<count[i])
				max=count[i];
		}
		StringBuffer buf = new StringBuffer();
		for (int i = 1; i <= N; i++) {
			if (max == count[i])
				buf.append(i + " ");
		}

		bw.write(buf.toString());
		bw.flush();

	}

	public static void dfs( int n) {

		visited[n] = true;
		//count[start]++;
		count[n]++;
		

		for (int k : arr[n]) {
			if (!visited[k]) {
				dfs( k);
			}
		}

	}

}
