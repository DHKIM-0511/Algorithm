package solutions_0x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 보물_1026 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] a = new int[N];
        Integer[] b = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) a[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) b[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        int ans =0;
        for(int i = 0 ; i < N ; i++) ans += a[i]*b[i];
        System.out.println(ans);
    }
}
