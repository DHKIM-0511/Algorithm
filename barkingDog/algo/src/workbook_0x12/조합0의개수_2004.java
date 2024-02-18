package workbook_0x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 조합0의개수_2004 {
    static int n, m;
    static long two, five;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        two = find(n, 2) - find(m, 2) - find(n - m, 2);
        five = find(n, 5) - find(m, 5) - find(n - m, 5);

        System.out.println(Math.min(two, five));
    }

    static long find(long num, int p) {
        long cnt = 0;

        while (num / p > 0) {
            cnt += num / p;
            num /= p;
        }
        return cnt;
    }
}
