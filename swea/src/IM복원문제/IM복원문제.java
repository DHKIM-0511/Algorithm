package IM복원문제;

import java.util.Scanner;

public class IM복원문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트케이스 수
		for(int tc=1; tc<= T; tc++) {
			int N = sc.nextInt(); // 사람 숫자
			int k_min = sc.nextInt(); // 분반 최소 인원
			int k_max = sc.nextInt();// 분반 최대 인원
			
			int[] arr = new int[N]; // 사람마다 각 점수를 저장
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			boolean satisfy = false; // k_min 이상 k_max 이하를
			// 만족하지 않는다고 가정하고 시작
			int ans = Integer.MAX_VALUE; // 최소값을 찾아야 하므로
			
			for(int t1=2; t1<=99; t1++) {
				for(int t2=t1+1; t2<=100; t2++) {
					int a = 0; // a분반 학생수
					int b = 0; // b분반 ...
					int c = 0;
					
					for(int i=0; i<N; i++) {
						if(arr[i] < t1) c++;
						else if(arr[i] < t2) b++;
						else a++;
					}
					
					// a, b, c 가 k_min 이상 k_max이하
					if(a >= k_min && b >= k_min && c >= k_min && a <= k_max && b <= k_max && c <= k_max) {
						satisfy = true;
						int min = Math.min(Math.min(a, b), c);
						int max = Math.max(Math.max(a, b), c);
						
						int diff = max - min;
						if (diff < ans) ans = diff;
					}
				}
			}
			if(satisfy) {
				System.out.println("#"+tc+" "+ans);
			} else {
				System.out.println("#"+tc+" -1");
			}
		}
	}
}
