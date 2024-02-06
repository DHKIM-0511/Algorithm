package workbook_0x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주식_11051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < T ; tc++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st= new StringTokenizer(br.readLine());
            int[] input = new int[N];
            for(int i = 0 ; i < N ; i++){
                input[i] = Integer.parseInt(st.nextToken());
            }
            int max = input[N-1];
            long ans = 0;
            for(int i = N - 2 ; i >= 0 ; i--){
                if(input[i] > max) max = input[i];
                ans += max - input[i];
            }

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
