package workbook_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 팰린드롬_10942 {
    static int N,M;
    static int[] num = new int[2005];
    static int[][] memo = new int[2005][2005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++) num[i] = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N ; i++){
            memo[i][i] = 1;
            if(num[i-1] == num[i]) memo[i-1][i] = 1;
        }

        for(int i = 2; i < N ; i++){
            for(int j = 1 ; j <= N - i ; j++){
                int s = j, e = j+i;
                if(num[s] == num[e] && memo[s+1][e-1] == 1) memo[s][e] =1;
            }
        }

        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        while (M-->0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(memo[s][e]).append("\n");
        }

        System.out.println(sb);
    }
}
