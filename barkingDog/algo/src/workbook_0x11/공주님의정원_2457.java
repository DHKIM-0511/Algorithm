package workbook_0x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 공주님의정원_2457 {
    static int N;
    static List<int[]> flower = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m1 = Integer.parseInt(st.nextToken());
            int d1 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            int d2 = Integer.parseInt(st.nextToken());

            flower.add(new int[]{m1*100 + d1, m2*100 + d2}); // 날짜 파싱
        }
        int t = 301;
        int ans = 0;

        while (t < 1201){
            int nt = t;
            for(int[] f : flower){
                if(f[0] <= t && f[1] > nt) nt = f[1];
            }

            if(nt == t){
                System.out.println(0);
                return;
            }
            ans++;
            t = nt;
        }
        System.out.println(ans);
    }
}
