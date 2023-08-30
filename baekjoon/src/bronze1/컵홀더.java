package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 컵홀더 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int cnt = n+1;
		//컵홀더 개수 : n+1 - (커플좌석 n쌍) 
		String str = br.readLine();
		
		for(int i = 1 ; i < str.length() ; i++) {
			if(str.charAt(i)=='L' && str.charAt(i-1)=='L') {
				cnt--;
				i++;
			}
				
		}
		int ans = 0;
		if(cnt >= n)
			ans = n;
		else
			ans = cnt;
		System.out.println(ans);
	}
}
