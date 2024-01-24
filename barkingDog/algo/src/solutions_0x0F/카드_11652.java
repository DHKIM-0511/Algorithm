package solutions_0x0F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 카드_11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] input = new long[N];

        for(int i = 0 ; i < N ; i++){
            input[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(input);

        int cnt = 0;
        int maxCnt = 0;
        long ans = Long.MAX_VALUE;
        for(int i = 0 ; i < N ; i++){
            if(i == 0 || input[i-1] == input[i]){
                cnt++;
            }else{
                if(cnt > maxCnt){
                    maxCnt = cnt;
                    ans = input[i-1];
                }
                cnt=1;
            }
        }
        if(cnt > maxCnt){
            ans = input[N-1];
        }
        System.out.println(ans);
    }
}
