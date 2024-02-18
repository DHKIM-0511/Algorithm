package solutions_0x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드2_10816 {
    static int n,m;
    static int[] a,b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0 ; i < n ; i++) a[i] = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        b = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < m ; i++) b[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(a);

        StringBuilder sb = new StringBuilder();
        for(int i : b){
            sb.append(highSearch(i) - lowSearch(i)).append(" ");
        }
        System.out.println(sb);
    }

    private static int lowSearch(int target) {
        int l = 0;
        int r = n;
        while (l < r){
            int mid = (l+r)/2;
            if(a[mid] >= target) r = mid;
            else l = mid+1;
        }
        return l;
    }
    private static int highSearch(int target) {
        int l = 0;
        int r = n;
        while (l < r){
            int mid = (l+r)/2;
            if(a[mid] > target) r = mid;
            else l = mid+1;
        }
        return l;
    }
}
