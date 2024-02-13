package workbook_0x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 베르트랑공준_4948 {
    static int n = 123456*2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] a = new boolean[n+1];
        for(int i = 2; i*i <= n ; i++){
            if(a[i]) continue;
            for(int j = i*i ; j <= n ; j+=i){
                a[j] = true;
            }
        }

        while (true){
            int cur = Integer.parseInt(br.readLine());
            if(cur == 0 ) break;

            int cnt =0;
            for(int i = cur+1 ; i <= 2*cur ; i++) if (!a[i]) cnt++;
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
