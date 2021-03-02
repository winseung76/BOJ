import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10833 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		for (int i = 0; i < N; i++) {
			String[] sarr = br.readLine().split(" ");

			int stu = Integer.parseInt(sarr[0]);
			int apple = Integer.parseInt(sarr[1]);

			sum += apple % stu;

		}
		bw.write(sum + "\n");
		bw.flush();
	}

}
