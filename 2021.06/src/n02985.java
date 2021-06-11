import java.io.*;

public class n02985 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		int c = Integer.parseInt(input[2]);

		if (a + b == c)
			System.out.println(a + "+" + b + "=" + c);
		else if (a * b == c)
			System.out.println(a + "*" + b + "=" + c);
		else if (a - b == c)
			System.out.println(a + "-" + b + "=" + c);
		else if (a / b == c)
			System.out.println(a + "/" + b + "=" + c);
		else if (b + c == a)
			System.out.println(a + "=" + b + "+" + c);
		else if (b * c == a)
			System.out.println(a + "=" + b + "*" + c);
		else if (b - c == a)
			System.out.println(a + "=" + b + "-" + c);
		else if (b / c == a)
			System.out.println(a + "=" + b + "/" + c);
	}

}
