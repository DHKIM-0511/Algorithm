package workbook_0x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 날짜계산_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int e= Integer.parseInt(st.nextToken());
        int s= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        e--; s--; m--;

        int i = e;
        while(i % 28 != s) i += 15;

        int l = lcm(15, 28);
        while(i % 19 != m) i += l;
        System.out.println(i+1);
    }
    static int lcm(int a,int b){
        return a/gcd(a,b)*b;
    }

    private static int gcd(int a, int b) {
        if(a==0)return b;
        return gcd(b%a,a);
    }
}
