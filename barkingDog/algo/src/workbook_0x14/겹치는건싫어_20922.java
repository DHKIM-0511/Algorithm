package workbook_0x14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 겹치는건싫어_20922 {
    static int n,k;
    static int[] a,cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a= new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i <n ; i++) a[i] = Integer.parseInt(st.nextToken());

        cnt = new int[100005];
        cnt[a[0]]++;
        int r = 0;
        int max =0;
        for(int l = 0 ; l < n ; l++){
            while (r < n-1 && cnt[a[r+1]] < k){
                r++;
                cnt[a[r]]++;
            }
            if(r == n)break;
            max = Math.max(max, r-l+1);
            cnt[a[l]]--;
        }
        System.out.println(max);
    }
}
