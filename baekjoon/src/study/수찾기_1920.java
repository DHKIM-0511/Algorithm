package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수찾기_1920 {
	static int n;
	static int m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		int[] arr= new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i< n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		int[] search = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < m ; i++) {
			search[i] = Integer.parseInt(st.nextToken());
		}
		BS(arr,search);
	}
	
	private static void BS(int[] arr, int[] search) {
		Arrays.sort(arr);
		
		a:for(int i = 0 ; i < m ; i++) {
			int start = 0;
			int end = n-1;
			
			while(start <= end) {
				int mid = (start+end)/2;
				
				if(arr[mid] == search[i]) {
					System.out.println(1);
					continue a;
				}else if(arr[mid] > search[i]){
					end = mid-1;
				}else
					start = mid+1;
			}
			System.out.println(0);
		}
		
	}
}
