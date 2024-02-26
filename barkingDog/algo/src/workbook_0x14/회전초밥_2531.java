package workbook_0x14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 회전초밥_2531 {
    static int n, d, k, c, eatCnt, ans;
    static int[] a, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        a = new int[n * 2];
        cnt = new int[d + 1];
        cnt[c]++;
        eatCnt = 1;
        ans = 1;

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
            a[n + i] = a[i];
        }

        for (int i = 0; i < n * 2; i++) {
            if (i >= k) rollback(a[i - k]);
            eat(a[i]);
        }
        System.out.println(ans);
    }

    static void rollback(int sushi) {
        cnt[sushi]--;
        if (cnt[sushi] == 0) eatCnt--;
    }

    static void eat(int sushi) {
        if (cnt[sushi] == 0) {
            eatCnt++;
            ans = Math.max(ans, eatCnt);
        }
        cnt[sushi]++;
    }
}