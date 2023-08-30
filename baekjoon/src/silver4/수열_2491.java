package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열_2491 {
	public static void main(String[] args) throws IOException{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		
		 int upCnt = 1;
	     int dwCnt = 1;
	     int uptmp = 1;
	     int dwtmp = 1;
		
		for(int i = 0 ; i < n ; i++)
			arr[i] = Integer.parseInt(st.nextToken());
			
		for(int i = 1 ; i < n ; i++) {
            if(arr[i] >= arr[i-1]) {//오름차순 검사
                uptmp++;
                if(uptmp > upCnt) // uptmp를 갱신할 때마다 upCnt도 갱신
                    upCnt = uptmp;
            } else {
                uptmp = 1;
            }
            if(arr[i] <= arr[i-1]) {//내림차순 검사
                dwtmp++;
                if(dwtmp > dwCnt) // dwtmp를 갱신할 때마다 dwCnt도 갱신
                    dwCnt = dwtmp;
            } else {
                dwtmp = 1;
            }
        }

		int ans = Math.max(upCnt, dwCnt);
		
		System.out.println(ans);
	}
}