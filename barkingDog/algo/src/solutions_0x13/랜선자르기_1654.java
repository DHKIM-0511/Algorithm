package solutions_0x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 랜선자르기_1654 {
    static int k,n;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        k = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        a = new int[k];
        for(int i = 0 ; i < k ; i++)a[i] = Integer.parseInt(br.readLine());
        System.out.println(bs());
    }

    private static long bs() {
        long l = 1;
        long r = 0x7fffffff;
        while (l < r){
            long mid = (l+r+1)/2;

            long cnt =0;
            for(int i = 0 ; i < k ;i++){
                cnt += a[i] / mid;
            }

            if(cnt >= n) l = mid;
            else r = mid-1;
        }
        return l;
    }
}
