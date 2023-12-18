package workbook_0x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두수의합_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[n];
        for(int i = 0 ; i < n ; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());
        //input 끝

        int ans = 0;
        int[] occur = new int[2000001];

        for(int i = 0 ; i < n ; i++){
            if(x - input[i] >0 && occur[x - input[i]] == 1){
                ans++;
            }
            occur[input[i]]++;
        }
        System.out.println(ans);
    }
}
