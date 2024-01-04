package solutions_0x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Z_1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int R = Integer.parseInt(input[1]);
        int C = Integer.parseInt(input[2]);

        System.out.println(getNumber(N, R, C));
    }

    private static int getNumber(int n, int r, int c) {
        if(n == 0) return 0;
        int mid = (int) Math.pow(2, n-1);
        //좌상
        if(r < mid && c < mid) return getNumber(n-1, r, c);
        //우상
        if(r < mid && c >= mid) return mid * mid + getNumber(n-1, r, c - mid);
        //좌하
        if(r >= mid && c < mid) return 2 * mid * mid + getNumber(n-1, r - mid, c);
        return 3 * mid * mid + getNumber(n-1, r - mid, c - mid);
    }
}
