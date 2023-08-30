package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바구니뒤집기_10811 {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr= new int[n];
		for(int i = 0 ; i < n ; i++)
			arr[i] = i+1;
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int tmp = Math.round((r-l)/2);
			
			for(int j = 0 ; j <= tmp ; j++) {
				
				int dum = arr[l-1];
				arr[l-1] = arr[r-1];
				arr[r-1] = dum;
				l++;
				r--;
				
			}
		}
		
		for(int a : arr) {
			System.out.printf("%d ",a);
		}
	}
}
//12345
//21345
//21435
//34125
//34125
