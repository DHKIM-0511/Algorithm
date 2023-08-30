package silver4;

import java.util.Scanner;

public class 설탕배달2_26099 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long ans = 0;

        while (N % 5 != 0) {
            N -= 3;
            ans++;
            if (N < 0) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(ans + N / 5);
	}
}
