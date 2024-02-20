package workbook_0x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 공유기설치_2110 {

    static int n, c;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(br.readLine());
        Arrays.sort(a);
        if (c == 2) {
            System.out.println(a[n - 1] - a[0]);
            return;
        }
        System.out.println();
    }
}
