package silver3;

import java.util.Scanner;

public class 퇴사_14501 {
	static int[][] arr ;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arr = new int[n][2];
		
		for(int i = 0 ; i < n ; i++) {
			arr[i][0] = sc.nextInt(); // T
			arr[i][1] = sc.nextInt(); // P
		}
		//최대 이익을 가져가야함 , 퇴사날 이후까지 진행되는 상담은 못함
		//즉 idx + arr[idx][0] < n 선택가능
		//선택 시 idx +arr[idx][0]
		//그중 최대 sum
		//흠......
		
	}
}
