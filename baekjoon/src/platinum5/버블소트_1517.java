package platinum5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 버블소트_1517 {
	static long ans = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		mergeSort(arr , 0 , arr.length-1);
		System.out.println(ans);
	}
	private static void mergeSort(long[] arr, int left, int right) {
		if(left < right) {
			int mid = (left+right)/2;
			mergeSort(arr , left , mid);
			mergeSort(arr , mid+1 ,right);
			merge(arr , left , mid ,right);
		}
	}
	private static void merge(long[] arr, int left, int mid, int right) {
		int sizeOfA = mid-left+1;
		int sizeOfB = right - mid;
		
		long[] A = new long[sizeOfA];
		long[] B = new long[sizeOfB];
		int L = left;
		int R = mid+1;
		
		for(int i = 0 ; i < sizeOfA ; i++) A[i] = arr[L+i];
		for(int i = 0 ; i < sizeOfB ; i++) B[i] = arr[R+i];
		
		int i = 0;
		int j = 0;
		int k = L;
		
		while(i < sizeOfA && j < sizeOfB) {
			if(A[i] <= B[j]) {
				arr[k++] = A[i++];
			}
			else { 
				arr[k++] = B[j++];
				ans += sizeOfA-i;
			}
		}
		
		for( ; i < sizeOfA ; i++) {
			arr[k++] = A[i];
		}
		for( ; j < sizeOfB ; j++) { 
			arr[k++] = B[j];
		}
		
	}
}
