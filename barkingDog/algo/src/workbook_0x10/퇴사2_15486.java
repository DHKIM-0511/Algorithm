package workbook_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사2_15486 {
    static int N;
    static int[][]TP = new int[1500005][2];
    static int[] memo = new int[1500005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            TP[i][0] = Integer.parseInt(st.nextToken());
            TP[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i =N ; i >= 1 ; i--){
            if(i+TP[i][0] <= N+1){
                memo[i] = Math.max(memo[i+TP[i][0]] + TP[i][1], memo[i+1]);
            }else {
                memo[i] = memo[i+1];
            }
        }
        int ans = 0;
        for(int i = 1 ; i <= N ; i++){
            if(memo[i] >ans) ans = memo[i];
        }
        System.out.println(ans);
    }
}
