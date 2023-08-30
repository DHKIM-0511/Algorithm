package d3;

import java.util.Arrays;
import java.util.Scanner;

public class 진기의최고급붕어빵_1860 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt(); // 손님의 수
			int M = sc.nextInt(); // 붕어빵 쿨타임
			int K = sc.nextInt(); // M초마다 만들어지는 붕어빵 갯수
			
			String ans = "Possible";
			
			int[] person = new int[N]; // 사람들의 도착 시간
			for(int i=0; i<N; i++) {
				person[i] = sc.nextInt();
			}
			
			// 우리 정렬을 하면
			// 기본적으로 오름차순으로 정렬
			Arrays.sort(person);
			// 인덱스 정보를 활용할 수 있게 됨
			// 인덱스가 바로 도착순서가 됨
			// person[i] : i번째로 도착하는 사람이 도착하는 시간
			// 도착하는 시간 => 해당 시점까지 만들어지는 붕어빵의 총량을 알 수 있음
			// 인덱스 => 해당 시점까지 몇명이 와서 먹었는지 총량을 알 수 있음
			
			for(int i=0; i<N; i++) {
				
				// 붕어빵 개수
				int bread = (person[i]/ M )*K;
				
				if(bread - 1 - i < 0) {
					ans = "Impossible";
					break;
				}
				
			}
			
			System.out.println("#"+tc+" "+ans);
			
			
		}
	}
}
