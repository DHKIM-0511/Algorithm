package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 징검다리 {
    static int N;
    static int[] bridge = new int[3005];
    static int[] memo = new int[3005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            bridge[i] = Integer.parseInt(st.nextToken());
            memo[i] = 1;
        }

        for(int i = 1; i <= N ; i++){
            for(int j = 1 ; j <= i ; j++){
                if(bridge[j] < bridge[i]) memo[i] = Math.max(memo[i], memo[j]+1 );
            }
        }
        int ans = 0;
        for(int i =1 ; i <= N ; i++){
            if(ans < memo[i]) ans = memo[i];
        }
        System.out.println(ans);
    }
}
