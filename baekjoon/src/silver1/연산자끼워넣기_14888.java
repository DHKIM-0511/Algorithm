package silver1;

import java.util.Arrays;
import java.util.Scanner;

public class 연산자끼워넣기_14888 {
	static int n,max , min ;
	static int[] arr , A ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		A = new int[n];
		arr = new int[4]; // 0 = + , 1 = - , 2 = * , 3 = /
		
		for(int i = 0 ; i < n ; i++) {
			A[i] = sc.nextInt();
		}
		for(int i = 0 ; i < 4 ; i++) arr[i] = sc.nextInt();
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		comb(0, new String[n-1]);
		
		System.out.println(max);
		System.out.println(min);
	}

	private static void comb(int idx , String[] sel) {
		if(idx == n-1) {
//			System.out.println(Arrays.toString(sel));
			int[] copy = Arrays.copyOf(A, A.length);
			for(int i = 0 ; i < sel.length ; i++) {
				if(sel[i] == "+") {
					copy[i+1] = copy[i] + copy[i+1];
				}else if(sel[i] == "-") {
					copy[i+1] = copy[i] - copy[i+1];
				}else if(sel[i] == "*") {
					copy[i+1] = copy[i] * copy[i+1];
				}else {
					copy[i+1] = copy[i] / copy[i+1];
				}
			}
			int sum = copy[copy.length-1];
			max = Math.max(max, sum);
			min = Math.min(min, sum);
		}else {
			for(int i = 0 ; i < 4 ; i++) {
				if(arr[i] > 0) {
					if(i == 0) {
						sel[idx] = "+";
						arr[i]--;
						comb(idx+1 , sel);
						arr[i]++;
					}else if(i == 1) {
						sel[idx] = "-";
						arr[i]--;
						comb(idx+1 , sel);
						arr[i]++;
					}else if(i == 2) {
						sel[idx] = "*";
						arr[i]--;
						comb(idx+1 , sel);
						arr[i]++;
					}else {
						sel[idx] = "/";
						arr[i]--;
						comb(idx+1 , sel);
						arr[i]++;
					}
				}
			}
		}
	}
}
