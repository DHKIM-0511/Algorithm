package bronze3;

import java.util.Scanner;

public class 별찍기_7_2444 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int left = (2*n-1)/2;
		int right = (2*n-1)/2;
		
		for(int i = 0 ; i < 2*n-1 ; i++) {
			for(int j = 0 ; j < 2*n-1 ; j++) {
				
				if(j >= left && right >= j) {
					System.out.print("*");
				}else if(j < left)
					System.out.print(" ");
				
			}
			
			System.out.println();
			
			if(i < (2*n-1)/2) {
				left--;
				right++;
			}else {
				left++;
				right--;
			}
				
		}
		
		
		
		
	}
}
