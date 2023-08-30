package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 합이0_3151 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] student = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			student[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(student);
		
		int l =0;
		int r = N-1; 
		int ans = 0;
		
		for(int fix = 0 ; fix < N ;fix++) {
			if(student[fix] > 0 ) break;
			int tmp = student[fix];
			int start = fix+1;
			int end = N-1;
			
			while(start < end) {
				int sum = tmp + student[start] + student[end];
				
				if(sum == 0) {
					ans++;
				}
			}
		}
	}
}
