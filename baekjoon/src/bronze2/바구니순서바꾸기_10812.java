package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 바구니순서바꾸기_10812 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		for(int i = 0 ; i < n ; i ++) {
			arr[i] = i+1;
		}
		
		for(int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int begin = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int mid = Integer.parseInt(st.nextToken());
			
			int[] tmp1 = Arrays.copyOfRange(arr, begin-1, mid-2);
			int[] tmp2 = Arrays.copyOfRange(arr, mid-1, end-1);
			int idx=0;
			for(int j = mid-1 ; j <=end-1 ; j++) {
				arr[begin-1] = tmp2[idx++];
				begin++;
			}
			idx=0;
			for(int j = begin-1 ; j <= mid-2 ; j++) {
				arr[begin-1] = tmp1[idx++];
			}
		}
		
			System.out.println(Arrays.toString(arr));
		
	}
}
