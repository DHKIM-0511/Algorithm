package workbook_0x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드_10815 {
    static int n,m;
    static int[]a,b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n =Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++) a[i] = Integer.parseInt(st.nextToken());

        m= Integer.parseInt(br.readLine());
        b = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < m ; i++) b[i] = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        Arrays.sort(a);
        for(int i : b){
            if( bs(i) ) sb.append(1);
            else sb.append(0);
            sb.append(" ");
        }
        System.out.println(sb);
    }

    private static boolean bs(int target) {
        int l = 0;
        int r = n-1;
        while (l<=r){
            int mid = (l+r) /2;
            if(a[mid] == target)return true;
            if(a[mid] > target) r= mid-1;
            else l = mid+1;
        }
        return false;
    }
}
