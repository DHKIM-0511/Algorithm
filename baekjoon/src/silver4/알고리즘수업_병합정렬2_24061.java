package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 알고리즘수업_병합정렬2_24061 {
	static int cnt;
	static int n,k;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		cnt=0;
		mergeSort(arr , 0 , arr.length-1);
		if(cnt >= k)
			System.out.println(sb);
		else
			System.out.println(-1);
//		System.out.println(Arrays.toString(arr));
//		System.out.println(cnt);
	}

	private static void mergeSort(int[] arr, int left, int right) {
		if(left<right) {
			int mid = (left + right) / 2;
			
			mergeSort(arr , left , mid);
			cnt++;
			mergeSort(arr , mid+1 , right);
			cnt++;
			merge(arr , left , mid , right);
			if(cnt == k) {
				for(int i : arr) {
					sb.append(i).append(" ");
				}
			}
		}
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		int sizeOfA = mid-left+1;
		int sizeOfB = right-mid;
		
		int[] A = new int[sizeOfA];
		int[] B = new int[sizeOfB];
		
		int L = left;
		int R = mid+1;
		
		for(int i = 0 ; i < sizeOfA ; i++) {
			A[i] = arr[L+i];
		}
		for(int i = 0 ; i < sizeOfB ; i++) {
			B[i] = arr[R+i];
		}
		
		int i = 0;
		int j = 0;
		int k = L;
		
		while(i < sizeOfA && j < sizeOfB) {
			
			if(A[i] < B[j]) {
				arr[k++] = A[i++];
			}else
				arr[k++] = B[j++];
		}
		
		for(;i<sizeOfA ; i++) {
			arr[k++] = A[i];
		}
		for(;j<sizeOfB ; j++) {
			arr[k++] = B[j];
		}
	}
}