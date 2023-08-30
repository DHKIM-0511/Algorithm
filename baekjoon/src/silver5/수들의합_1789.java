package silver5;

import java.util.Scanner;

public class 수들의합_1789 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Long N = sc.nextLong();
		long sum=0;
		long cnt=0;
        
		for(long i=1;i<=N;i++) {
			sum+=i;
			cnt++;
			if(N<sum) {
				System.out.println(cnt-1);
				break;
			}
			else if(N==sum) {
				System.out.println(cnt);
				break;
			}
		}
		
	}
}
