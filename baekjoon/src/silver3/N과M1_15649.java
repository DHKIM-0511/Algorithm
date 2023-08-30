package silver3;

import java.util.Scanner;

public class N과M1_15649 {
	static int n,m;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();  // 1 ~ n 까지 중복없이
		m = sc.nextInt();  //m 개 고름
		boolean[] checked = new boolean[n+1];
		
		find(0,new int[m] ,checked);
		
		System.out.println(sb);
	}

	private static void find(int cnt, int[] tmp, boolean[] checked) {
		
		if(cnt >= m) {
			for(int i = 0 ; i < m ; i++)
				sb.append(tmp[i]).append(" ");
			sb.append("\n");
			
		}
		else {
			for(int i=1; i<=n; i++) {
				if(checked[i] == false) {
					tmp[cnt] = i;
					checked[i] = true; // 습관화 해두시면 좋습니다.  항상 트루 -> 재귀호출 -> 폴스 
					find(cnt+1, tmp, checked);
					checked[i] = false; // 재귀가 탈출되는 시점에 백트래킹
				}
			}
		}
	}	
}
