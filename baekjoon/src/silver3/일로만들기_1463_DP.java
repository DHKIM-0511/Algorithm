package silver3;

import java.util.Scanner;

public class 일로만들기_1463_DP {
	 static int[] d;

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        d = new int[n + 1];
	        System.out.println(dp(n));
	    }

	    private static int dp(int n) {
	        d[1] = 0;
	        for (int i = 2; i <= n; i++) {
	        	//d[i] == i를 1로 만드는 최소 횟수의 점화식
	            d[i] = d[i - 1] + 1;
	            if (i % 2 == 0) d[i] = Math.min(d[i], d[i / 2] + 1);
	            if (i % 3 == 0) d[i] = Math.min(d[i], d[i / 3] + 1);
	        }
	        return d[n];
	    }
}
