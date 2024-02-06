package workbook_0x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 선긋기_2170 {
    static int N;
    static boolean[] line = new boolean[2000000000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) + 1000000000;
            int r = Integer.parseInt(st.nextToken()) + 1000000000;

            for(int i = l ; i <=r ; i++){
                if(!line[i]){
                    line[i] = true;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
