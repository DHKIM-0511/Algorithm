package workbook_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전_9084 {
    static int n, m;
    static int[] coins, memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            coins = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            m = Integer.parseInt(br.readLine());
            memo = new int[m + 1];
            memo[0] = 1;

            for (int i = 0; i < n; i++) {
                for (int j = coins[i]; j <= m; j++) {
                    memo[j] += memo[j - coins[i]]; // j - coins[i]에 coins[i] 동전 추가
                }
            }
            sb.append(memo[m]).append('\n');
        }
        System.out.print(sb);
    }
}