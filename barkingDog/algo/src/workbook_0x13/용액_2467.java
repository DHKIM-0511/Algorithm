package workbook_0x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용액_2467 {
    static int n;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++) a[i] = Integer.parseInt(st.nextToken());

        int ans1=0, ans2=0;
        int sum = Integer.MAX_VALUE;
        int l = 0;
        int r = n-1;
        while (l<r){
            int tmp = a[l]+a[r];
            if(sum > Math.abs(tmp)){
                sum = Math.abs(tmp);
                ans1 = a[l];
                ans2 = a[r];
            }

            if(tmp == 0){
                System.out.println(a[l]+" "+a[r]);
                return;
            }
            if(tmp > 0) r--;
            else l++;
        }

        System.out.println(ans1+" "+ans2);
    }
}
