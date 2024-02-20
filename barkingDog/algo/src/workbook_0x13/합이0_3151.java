package workbook_0x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 합이0_3151 {
    static int n;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++) a[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(a);

        long cnt = 0;
        for(int i = 0 ; i < n-1 ; i++){
            for(int j = i+1 ; j < n ; j++){
                int upIdx = upSearch(j+1,-a[i]-a[j]);
                int lowIdx = lowSearch(j+1,-a[i]-a[j]);
                cnt += upIdx - lowIdx;
            }
        }

        System.out.println(cnt);
    }

    private static int upSearch(int start, int target) {
        int l = start;
        int r = n;
        while (l<r){
            int mid =(l+r)/2;
            if(a[mid] > target) r = mid;
            else l = mid+1;
        }
        return l;
    }
    private static int lowSearch(int start, int target) {
        int l = start;
        int r = n;
        while (l<r){
            int mid =(l+r)/2;
            if(a[mid] >= target) r = mid;
            else l = mid+1;
        }
        return l;
    }
}
