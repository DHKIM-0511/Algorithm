package workbook_0x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무자르기_2805 {
    static int n,m;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n];

        st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i = 0 ;i < n ;i++){
            a[i] = Integer.parseInt(st.nextToken());
            max = a[i] > max ? a[i] : max;
        }

        System.out.println(bs(max));
    }

    private static int bs(int max) {
        int l = 0;
        int r = max;
        while (l<r){
            int mid =(l+r+1)/2;

            if(check(mid)) l =mid;
            else r = mid-1;
        }
        return l;
    }

    private static boolean check(int mid) {
        long sum = 0;
        for(int i = 0 ; i < n ; i++){
            int diff = a[i] - mid;
            if(diff > 0) sum += diff;
        }

        return sum >= m;
    }
}
