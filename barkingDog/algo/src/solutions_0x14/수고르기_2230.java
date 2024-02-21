package solutions_0x14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수고르기_2230 {
    static int n,m;
    static int a[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        a = new int[n];
        for(int i = 0 ; i < n ; i++) a[i] = Integer.parseInt(br.readLine());
        Arrays.sort(a);

        int l = 0;
        int r = 0;
        int diff = Integer.MAX_VALUE;
        while ( r < n && l < n ){
            int tmp = a[r] - a[l];
            if( tmp >= m ){
                diff = tmp < diff ? tmp : diff;
                l++;
            }else{
                r++;
            }
        }
        System.out.println(diff);
    }
}
