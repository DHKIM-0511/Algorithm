package workbook_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속합_1912 {
    static int N;
    static int[] num = new int[100005];
    static int[] memo = new int[100005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++) num[i] = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= N ; i++) memo[i] = Math.max(0,memo[i-1]) + num[i];

        int ans = Integer.MIN_VALUE;
        for(int i = 1; i <= N ; i++)ans = Math.max(ans, memo[i]);
        System.out.println(ans);
    }
}
