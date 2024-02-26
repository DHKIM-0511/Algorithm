package workbook_0x14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수들의합2_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++) a[i] = Integer.parseInt(st.nextToken());

        int r = 0;
        int sum = a[0];
        int cnt = 0;
        for(int l = 0 ; l < n ; l++){
            while (r < n && sum < m){
                r++;
                if (r != n) sum += a[r];
            }
            if(r >=n) break;
            if(sum == m) cnt++;
            sum -= a[l];
        }
        System.out.println(cnt);
    }
}
