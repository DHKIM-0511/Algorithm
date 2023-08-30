package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정곤이의단조증가하는수_6190 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= t ; tc++) {
			
			int n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			int[] A = new int[n];
			int ans = -1;
			
			for(int i = 0 ; i < n ; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			
			for(int i = 0 ; i < n ; i++) {
				for(int j = i+1 ; j < n ; j++ ) {
					boolean danjo = true; 
					int temp = A[i] * A[j];  
					
					String str = Integer.toString(temp); // int를 string으로 변환
					for(int k = 1 ; k < str.length() ; k++) {
						if(str.charAt(k)-'0' < (str.charAt(k-1)-'0')) { // 앞 인덱스에 저장된 값이 더 크면 
							danjo = false; // 단조 증가하는 수 가 아님
							break;
						}
					}
					if(danjo) {
						// 단조면 크기 비교후 저장
						ans = Math.max(ans, temp); 
					}
				}
			}
			
			
			System.out.println("#"+tc+" "+ans);
		}	
	
	}
}
