import java.util.Scanner;

public class n10886_0_Not_Cute_1_Cute {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int zero=0,one=0;
		for(int i=0;i<N;i++) {
			if(sc.nextInt()==0)
				zero++;
			else
				one++;
		}
		System.out.println(zero>one ? "Junhee is not cute!" : "Junhee is cute!");
	}
}
