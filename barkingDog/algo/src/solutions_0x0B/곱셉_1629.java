package solutions_0x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 곱셉_1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int C = Integer.parseInt(input[2]);

        System.out.println(fnc(A,B,C));
    }

    private static long fnc(int a, int b, int c) {
        if(b == 1) return a % c;
        long value = fnc(a, b/2, c);
        value = value * value % c;
        if(b % 2 == 0) return value;
        return value * a % c;
    }
}
