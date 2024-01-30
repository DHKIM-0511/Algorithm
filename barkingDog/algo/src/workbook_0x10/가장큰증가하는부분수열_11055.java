package workbook_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장큰증가하는부분수열_11055 {
    static int N;
    static int[] num = new int[1005];
    static int[] memo = new int[1005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N ; i++){
            num[i] = Integer.parseInt(st.nextToken());
            memo[i] = num[i];
        }

        for(int i = 1; i <= N ; i++){
            for(int j = 1 ; j <= i ; j++){
                if(num[j] < num[i]) memo[i] = Math.max(memo[i] , memo[j] + num[i]);
            }
        }
        int ans = 0;
        for(int i = 1 ; i <= N ; i++){
            if(memo[i] > ans) ans = memo[i];
        }
        System.out.println(ans);
    }
}
