package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수찾기_1978 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cnt = 0 ;
		int pn;
		
		for(int i = 0 ; i < n ; i++) { 
			pn = Integer.parseInt(st.nextToken());// n개 숫자 pn
				for(int j = 2 ; j <= pn ; j++) {
					if(j == pn)cnt++;						
					if( pn % j == 0)break;
				}
		}
		System.out.println(cnt);
	
	}
}
