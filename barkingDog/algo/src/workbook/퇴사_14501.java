package workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_14501 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] memo = new int[n+2];
        int[][] input = new int[n][2];

        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 2 ; j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = n-1 ; i >= 0 ; i--){
            if(i + input[i][0] <= n){
                memo[i] = Math.max(memo[i + input[i][0]] +input[i][1] , memo[i+1]);
            }else {
                memo[i] = memo[i+1];
            }
        }
        int ans = 0;
        for(int i : memo)ans = Math.max(ans, i);
        System.out.println(ans);
    }
}
