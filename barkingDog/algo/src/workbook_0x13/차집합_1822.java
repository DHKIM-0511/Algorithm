package workbook_0x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 차집합_1822 {
    static int n,m;
    static int[] a,b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n];
        b= new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++) a[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < m ; i++) b[i] = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Arrays.sort(b);
        int cnt =0;
        for(int i : a){
            int idx = Arrays.binarySearch(b,i);
            if( idx < 0){
                cnt++;
                list.add(i);
            }
        }
        Collections.sort(list);
        for(int i : list) sb.append(i).append(" ");

        System.out.print(cnt+"\n"+sb);
    }
}
