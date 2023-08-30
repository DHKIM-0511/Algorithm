package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 간단한소인수분해_1945 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= t ; tc++) {
			
			int n = Integer.parseInt(br.readLine());
			int a = 0;  //n / 2
			int b = 0;  //n / 3
			int c = 0;  //n / 5
			int d = 0;  //n / 7
			int e = 0;  //n /11
			
			while( n%2==0 ) { //n을 2로 나눈 나머지가 0이 아닐때까지 나눈다..
				n /= 2;
				a++;
			}
			while( n%3==0 ) {
				n /= 3;
				b++;
			}
			while( n%5==0 ) {
				n /= 5;
				c++;
			}
			while( n%7==0 ) {
				n /= 7;
				d++;
			}
			while( n%11==0 ) {
				n /= 11;
				e++;
			}
			
			System.out.printf("#%d %d %d %d %d %d\n",tc,a,b,c,d,e);
		}
		
		
	}
}
