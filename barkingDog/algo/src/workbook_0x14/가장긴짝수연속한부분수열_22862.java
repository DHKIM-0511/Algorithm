package workbook_0x14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴짝수연속한부분수열_22862 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] s= new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++) s[i] = Integer.parseInt(st.nextToken());

        int ans = 0;
        int cnt = 0;
        int r = 0;
        if(s[0] % 2 == 1) cnt++;
        for(int l = 0 ; l < n ; l++){
            while (r < n-1 && cnt + s[r+1] % 2 <= k){
                r++;
                cnt+=s[r]%2;
            }
            ans = Math.max(ans, r-l+1-cnt);
            cnt-=s[l]%2;
        }
        System.out.println(ans);
    }
}
