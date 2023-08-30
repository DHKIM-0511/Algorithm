package gold4;

import java.util.Scanner;

public class NQueen_9663 {
    static int[] col;
    static int n;
    static int sum;

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        col = new int[n + 1];
        sum = 0;
        nQueen(0);
        System.out.println(sum);
    }

    // 서로 공격할 수 있는 가능성이 있는지를 체크
    public static boolean check(int i) {
        int k = 1;
        boolean check = true;

        while (k < i && check) {
        	if (col[i] == col[k] || Math.abs(col[i] - col[k]) == i - k) // 같은 열이나 대각선 상에 존재하는가?
        		check = false;
        	k++;
        }

        return check;
    }

    public static void nQueen(int i) {
        if (check(i)) { 
            if (i == n) { // 모든 퀸을 놓을 수 있다면, 답을 출력하고 리턴
                sum++;
                return;
            }
            for (int j = 1; j <= n; j++) { // 다음 퀸을 놓기 위해 반복
                col[i + 1] = j;
                nQueen(i + 1);
            }
        }
    }
}
