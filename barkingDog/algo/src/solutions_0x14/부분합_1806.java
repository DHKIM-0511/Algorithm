package solutions_0x14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class 부분합_1806 {
    static int n,s;
    static int a[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++) a[i] = Integer.parseInt(st.nextToken());

        int r = 0;
        int len = Integer.MAX_VALUE;
        int sum = a[0];
        for(int l = 0 ; l < n ; l++){
            while ( r < n && sum < s){
                r++;
                if(r != n) sum += a[r];
            }
            if(r == n) break;
            len = Math.min(len, r-l+1);
            sum -= a[l];
        }
        System.out.println(len == Integer.MAX_VALUE ? 0 : len);
    }
}
