package solutions_0x0E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기5_15688 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] countArr = new int[2000005];

        while (N-- > 0){
            int cur = Integer.parseInt(br.readLine());
            countArr[cur+1000000]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i  = 0 ; i < countArr.length; i ++){
            while (countArr[i]-- > 0){
                sb.append(i-1000000).append("\n");
            }
        }
        System.out.println(sb);
    }
}
