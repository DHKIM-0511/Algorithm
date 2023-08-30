package silver2;

import java.util.Scanner;

public class 랜선자르기_1654 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt(); // 최초 랜선 수
		int n = sc.nextInt(); // 자른 후 랜선 수
		
		int[] line = new int[k]; // 각 랜선의 길이
		long left = 0;
		long right = 0;
		long mid = 0;
		
		for(int i = 0 ; i < k ; i++) {
			line[i] = sc.nextInt();
			
			if(right < line[i]) {
				right = line[i];
			}
		}
		right++; // 초기값에서 0이 들어가는것을 방지
		
		while(left < right) {
			mid = (left+right) /2;
			
			//잘랐을 때 갯수
			long cnt = 0;
			
			for(int i = 0 ; i < k ; i++) {
				 cnt += line[i]/mid;
			}
			if(cnt < n) {
				right = mid;
			}
			else {
				left = mid + 1;
			}
			
		}
		System.out.println(left-1);
	}
}
