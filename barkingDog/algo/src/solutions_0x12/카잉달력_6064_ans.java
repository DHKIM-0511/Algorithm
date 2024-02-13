package solutions_0x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카잉달력_6064_ans {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            StringTokenizer st =new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(sol(M,N,x,y)).append("\n");
        }
        System.out.println(sb);
    }
    static int lcm(int a, int b){
        return a/ gcd(a,b) * b;
    }

    public static int gcd(int a, int b) {
        if(a == 0) return b;
        return gcd(b%a, a);
    }
    static int sol(int m,int n,int x,int y){
        if( x == m ) x= 0;
        if( y == n ) y= 0;
        int l = lcm(m,n);
        for(int i = x; i <= l; i += m){
            if(i == 0) continue;
            if(i % n == y)
                return i;
        }
        return -1;
    }
}
