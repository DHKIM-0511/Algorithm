package silver3;

import java.util.Scanner;

public class N과M4_15652 {
	static int n,m;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();  // 1 ~ n 까지 중복없이
		m = sc.nextInt();  //m 개 고름
		
		find(1,0,new int[m]);
		
		System.out.println(sb);
	}

	private static void find(int lastIdx, int cnt, int[] tmp) {
		
		if(cnt >= m) {
			for(int i = 0 ; i < m ; i++)
				sb.append(tmp[i]).append(" ");
			sb.append("\n");
		}
		else {
			for(int i=lastIdx; i<=n; i++) {
				tmp[cnt] = i;
				find(i,cnt+1, tmp);
			}
		}
	}	
}
