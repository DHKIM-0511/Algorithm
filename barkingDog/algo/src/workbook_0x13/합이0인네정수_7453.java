package workbook_0x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 합이0인네정수_7453 {
    static int n;
    static int[]a,b,c,d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int [n];
        b = new int [n];
        c = new int [n];
        d = new int [n];
        int[] cd = new int[n * n];
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                cd[i * n + j] = c[i] + d[j];
            }
        }
        Arrays.sort(cd);

        long cnt = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                cnt += upSearch(cd,-a[i]-b[j])-lowSearch(cd,-a[i]-b[j]);
            }
        }
        System.out.println(cnt);
    }

    private static int lowSearch(int[] cd, long target) {
        int l = 0;
        int r = cd.length;
        while (l<r){
            int mid = (l+r)/2;
            if(cd[mid] >= target)r=mid;
            else l=mid+1;
        }
        return l;
    }
    private static int upSearch(int[] cd, long target) {
        int l = 0;
        int r = cd.length;
        while (l<r){
            int mid = (l+r)/2;
            if(cd[mid] > target)r=mid;
            else l=mid+1;
        }
        return l;
    }
}
