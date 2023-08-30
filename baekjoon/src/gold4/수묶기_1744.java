package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수묶기_1744 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int n = Integer.parseInt(br.readLine());
		
		int[] num = new int[n];
		
		for(int i = 0 ; i< n ; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(num);
		int ans = 0;
		for(int i = n-1 ; i >=0 ; i--) {
			if(num[i] >0 && num[i-1] <=0 ) {
				ans = num[i] + num[i-1];
			}
			
		}
		
		System.out.println(ans);
	}
}
