package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타레슨_2343 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 강의 수
		int m = Integer.parseInt(st.nextToken()); // 블루레이 수
		
		int[] time = new int[n]; // 각 강의 소요시간
		
		
		int left  = 0; 
        int right  = 0; 
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < n ; i++) {
			time[i] = Integer.parseInt(st.nextToken());
			right += time[i];// 모든 강의 시간의 합 = 최대 값 ( m = 1 ) 
			
			if(left < time[i])
				left = time[i]; // 강의 시간 중 최대값 = 최소 값
		}
		
		while(left <= right) {
			
            int mid = (left + right)/2; 
            //하나의 블루레이에 들어갈 강의 시간의 합
            int sum = 0;
            //가정일때 필요한 블루레이 개수
            int cnt = 0;
            
            for(int i=0; i<n; i++) {
                if(sum + time[i] > mid) {
                    sum = 0;
                    cnt++;
                }
                sum += time[i];
            }
            
            if(sum != 0) cnt++;
            if(cnt <= m) right = mid-1;
            else left = mid+1;
        }
		System.out.println(left);
	
	}
}
