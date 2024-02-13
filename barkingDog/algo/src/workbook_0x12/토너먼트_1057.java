package workbook_0x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 토너먼트_1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int lhs = Integer.parseInt(st.nextToken());
        int kjm = Integer.parseInt(st.nextToken());
        int r = Math.max(lhs,kjm);
        int l = Math.min(lhs,kjm);
        int round = 0;

        while (n > 1){

            round++;
            for (int i = 2; i <= n ; i+=2){
                if(i == r && i-1 == l){
                    System.out.println(round);
                    return;
                }
            }
            n = n%2 == 0 ? n/2: n/2 + 1;
            r = r%2 == 0 ? r/2: r/2 + 1;
            l = l%2 == 0 ? l/2: l/2 + 1;
        }
        System.out.println(round);
    }
}
