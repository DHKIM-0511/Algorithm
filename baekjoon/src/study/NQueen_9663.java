package study;

import java.util.Scanner;

public class NQueen_9663 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] checked = new int[n];
		boolean[][] arr = new boolean[n][n];
		
		nQeen(n, arr, checked);
//		System.out.println(nQeen(n));
	}

	private static int nQeen(int n, boolean[][] arr, int[] checked) {
		
		if( n == 1)
			return 1;
		
		int cnt = 0;
		checked[cnt] = cnt;
		
		
		
		return nQeen(n+1 ,arr ,checked);
	}
}
// n * n 사이즈 판위에 n개의 퀸이 있다
//서로 공격할 수 없게 놓는 경우의 수