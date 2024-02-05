package workbook_0x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM_11399 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        int[] b = new int[N];
        StringTokenizer st =new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) a[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(a);

        b[0] = a[0];
        for(int i = 1 ; i < N ; i++){
            b[i] = b[i-1] + a[i];
        }

        int ans = 0;
        for(int i : b) ans += i;
        System.out.println(ans);
    }
}
