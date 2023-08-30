package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 날짜계산기_1948 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= t ; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int StartM = Integer.parseInt(st.nextToken());
			int StartD = Integer.parseInt(st.nextToken());
			int EndM = Integer.parseInt(st.nextToken());
			int EndD = Integer.parseInt(st.nextToken());
			int ans = ((EndM-StartM) * 30) + (EndD-StartD+1);
			
			if(EndM-StartM > 0 ) {
				int[] M = new int[EndM - StartM];
				
				for(int i = 0 ; i < EndM - StartM ; i++) {
					M[i] = StartM++;
					if(M[i]==2) {
						ans-=2;
					}else if (M[i] < 8 && M[i] % 2 ==1) {
						ans+=1;
					}else if (M[i] >= 8 && M[i] % 2 == 0) {
						ans+=1;
					}
				}
				if(StartM==2) {
					ans-=2;
				}else if (StartM < 8 && StartM % 2 ==1) {
					ans+=1;
				}else if (StartM >= 8 && StartM % 2 == 0) {
					ans+=1;
				}
				
				
			}else 
				ans = EndD-StartD+1;
			
			
			
			System.out.println("#"+tc+" "+ans);
		}
	}
}
