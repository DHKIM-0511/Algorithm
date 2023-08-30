package silver3;

import java.util.Arrays;
import java.util.Scanner;

public class 칸토어집합_4779 {
	static int n;
//	static String str;
	static char[] c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 
		while(sc.hasNext()) {
			n = sc.nextInt();
			if(n == 0) {
				System.out.println("-");
			}else {
				String str = "";
				for(int i = 0 ; i < Math.pow(3, n) ;i++) {
					str += "-";
				}
				int left = 0;
				int right = str.length()-1;
				
				mergeSort(str , left , right);
			}
//			for(char a : c) {
//				System.out.println(a);
//			}
		}
	}
	private static void mergeSort(String str, int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			mergeSort(str , left , mid);
			mergeSort(str , mid +1 , right);
			merge(str , left , mid , right);
		}
	}
	private static void merge(String str, int left, int mid, int right) {
		char[] c = str.toCharArray();
		int n1 = mid - left +1;
		int n2 = right - mid;
		
		int L = left;
		int R = mid-1;
		
		char[] A = new char[n1];
		char[] B = new char[n2];
		
		for(int i = 0 ; i < n1 ; i++) {
			A[i] = c[L+i];
		}
		for(int j = 0 ; j < n1 ; j++) {
			B[j] = c[R+j];
		}
		
		int i = 0 ;
		int j = 0 ;
		int k = L ;
		
		while(i < n1 && j < n2) {
			//?????
		}
		
		for(; i <n1 ; i++) {
			c[k++] = A [i];
		}
		for(; j <n2 ; j++) {
			c[k++] = B [j];
		}
	}
	
}
