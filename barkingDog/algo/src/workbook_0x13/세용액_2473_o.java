package workbook_0x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 세용액_2473_o {
    static int n;
    static long[] a,ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new long[n];
        ans = new long[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i  < n ; i++) a[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(a);

        long sum = Long.MAX_VALUE;
        out:
        for(int i = 0 ; i < n-1 ; i++){
            for(int j = i+1; j < n ; j++){
                int l = j+1;
                int r = n;
                while (l<r){
                    int mid = (l+r)/2;
                    long tmp = a[i] + a[j] + a[mid];
                    if(sum > Math.abs(tmp)){
                        sum = Math.abs(tmp);
                        ans[0] = a[i];
                        ans[1] = a[j];
                        ans[2] = a[mid];
                    }
                    if(tmp == 0) break out;
                    if(tmp < 0) l = mid+1;
                    else r = mid;
                }
            }
        }
        System.out.println(ans[0] + " " + ans[1]+" "+ ans[2]);
    }
}
