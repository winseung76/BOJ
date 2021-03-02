import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10101 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());

		if (a + b + c == 180) {
			if (a == b && b == c)
				bw.write("Equilateral\n");
			else if (a == b || b == c || c == a)
				bw.write("Isosceles\n");
			else
				bw.write("Scalene\n");
		} else
			bw.write("Error\n");

		bw.flush();

	}

}
