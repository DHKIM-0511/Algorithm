package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 성공적인공연기획_4789 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= t; tc++) {
			//i번째 글자 : 기립박수하는 사람이 i-1인경우 박수치는사람
			String str = br.readLine();
			int sum = 0;
			int ans = 0;
			
			for(int i = 0 ; i < str.length() ; i++) {
				sum += str.charAt(i)-'0';
				
				if(str.charAt(i) == '0') {
					if(i >= sum+ans) //조건이 (누적합 + 고용인) 이상 인경우 
					ans = i - sum + 1;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
