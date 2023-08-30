package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두개의숫자열_1959 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		int sum = 0;
		
		for(int i = 0 ; i < tc ; i++) {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] a = new int[n];
		for(int j = 0 ; j < n ; j++)
			a[j]=Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] b = new int[m];
		for(int j = 0 ; j < m ; j++)
			b[j]=Integer.parseInt(st.nextToken());
		
		for(int j = 0 ; j < Math.abs(n-m+1);j++){
//			if(m>n)
//				a[j]
			
		}
		
		}
	}
}
