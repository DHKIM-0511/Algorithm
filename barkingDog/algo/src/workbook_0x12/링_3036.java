package workbook_0x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 링_3036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        while (t-- > 1){
            int r = Integer.parseInt(st.nextToken());
            int g = gcd(n,r);
            sb.append(n/g).append("/").append(r/g).append("\n");
        }
        System.out.println(sb);
    }

    private static int gcd(int a, int b) {
        if( a == 0 ) return b;
        return gcd(b%a, a);
    }
}
