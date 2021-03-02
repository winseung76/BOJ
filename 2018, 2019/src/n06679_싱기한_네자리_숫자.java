
public class n06679_싱기한_네자리_숫자 {
	public static void main(String[] args) {

		int sum_10 = 0, sum_12 = 0, sum_16 = 0;
		int temp;

		for (int n = 1000; n < 10000; n++) {
			temp = n;
			sum_10 = 0;
			sum_12 = 0;
			sum_16 = 0;
			while (temp >= 1) {
				sum_10 += temp % 10;
				temp = temp / 10;
			}
			temp = n;
			while (temp >= 1) {
				sum_12 += temp % 12;
				temp = temp / 12;
			}

			if (sum_10 != sum_12)
				continue;
			temp = n;
			while (temp >= 1) {
				sum_16 += temp % 16;
				temp = temp / 16;
			}

			if (sum_10 == sum_12 && sum_12 == sum_16)
				System.out.println(n);

		}
	}
}
