package workbook_0x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 쉽게푸는문제_1292 {
    static int[] num = new int[1005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = 1;
        int val = 1;
        int cnt = 1;
        while (num[1000] ==0){
            for(int i = 0 ; i < cnt ; i++){
                num[idx++] = val;
                if(idx == 1001) break;
            }
            cnt++;
            val++;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int l  = Integer.parseInt(st.nextToken());
        int r  = Integer.parseInt(st.nextToken());

        int sum = 0;
        for(int i = l ; i <= r; i++){
            sum += num[i];
        }
        System.out.println(sum);
    }
}
