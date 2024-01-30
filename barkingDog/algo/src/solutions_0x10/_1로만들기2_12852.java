package solutions_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1로만들기2_12852 {
    static int N;
    static int[][] memo = new int[1000005][4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i =2 ; i <= N ; i++){
            memo[i][0] = memo[i-1][0]+1; memo[i][1] =1;
            if(i % 2 == 0){
                if(Math.min(memo[i][0],memo[i/2][0]+1) == memo[i/2][0]+1){
                    memo[i][0] = memo[i/2][0]+1;
                    memo[i][1] = 0; memo[i][2] = 1;
                }
            }
            if(i % 3 == 0){
                if(Math.min(memo[i][0],memo[i/3][0]+1) == memo[i/3][0]+1){
                    memo[i][0] = memo[i/3][0]+1;
                    memo[i][1] = 0; memo[i][2] = 0;memo[i][3] = 1;
                }
            }
        }
        sb.append(memo[N][0]).append("\n").append(N).append(" ");

        int idx = N;
        while (true){
            if(idx == 1){
                break;
            }
            if(memo[idx][1] == 1){
                sb.append(idx-1).append(" ");
                idx--;
            }else if(memo[idx][2] == 1){
                sb.append(idx/2).append(" ");
                idx/=2;
            }else if(memo[idx][3] == 1){
                sb.append(idx/3).append(" ");
                idx/=3;
            }
        }
        System.out.println(sb);
    }
}
