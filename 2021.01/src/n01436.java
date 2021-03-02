import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class n01436 {

	static int N;
	static Vector<Long> list = new Vector<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		long n = 666;
		while (true) {

			String str = String.valueOf(n);
			if (str.contains("666"))
				list.add(n);

			if (list.size() == 10000)
				break;

			n++;
		}

		bw.write(list.get(N - 1) + "\n");
		bw.flush();

	}


}
