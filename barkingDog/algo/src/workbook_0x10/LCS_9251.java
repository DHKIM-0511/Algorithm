package workbook_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS_9251 {
    static int[][] memo = new int[1005][1005];
    //input1의 i-1 번째 글자와 2의 j-1번째 글자까지 최장 공통 수열의 길이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input1 = br.readLine().toCharArray();
        char[] input2 = br.readLine().toCharArray();

        for(int i = 1 ; i <= input1.length ; i++){
            for(int j = 1 ; j <= input2.length ; j++){
                if(input1[i-1] == input2[j-1]) memo[i][j] = memo[i-1][j-1] +1;
                else memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
            }
        }

        System.out.println(memo[input1.length][input2.length]);
    }
}
