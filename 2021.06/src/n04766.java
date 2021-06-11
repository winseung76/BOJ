import java.io.*;

public class n04766 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		double total = Double.parseDouble(br.readLine());

		while (true) {

			double temp = Double.parseDouble(br.readLine());

			if (temp == 999)
				break;

			bw.write(String.format("%.2f", temp - total) + "\n");
			total = temp;

		}

		bw.flush();

	}

}
