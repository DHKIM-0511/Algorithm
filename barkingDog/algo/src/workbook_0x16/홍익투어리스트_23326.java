package workbook_0x16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 홍익투어리스트_23326 {
    static int n,k;
    static TreeSet<Integer> a = new TreeSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            if(Integer.parseInt(st.nextToken()) == 1) a.add(i);
        }

        StringBuilder sb = new StringBuilder();
        int loc = 1;
        while (k-- >0){
            st =new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            if(q == 1){
                int x = Integer.parseInt(st.nextToken());
                if(a.contains(x)) a.remove(x);
                else a.add(x);
            }else if(q == 2){
                int x = Integer.parseInt(st.nextToken()) % n;
                loc += x;
                if( loc > n) loc %= n;
            }else{
                if(a.isEmpty()){
                    sb.append(-1).append("\n");
                    continue;
                }
                if(a.contains(loc)){
                    sb.append(0).append("\n");
                    continue;
                }
                int bigger = a.higher(loc) == null ? -1: a.higher(loc);
                int smaller = a.first();

                if(bigger != -1)  sb.append(bigger-loc).append("\n");
                else sb.append((n-loc) + smaller).append("\n");
            }
        }
        System.out.println(sb);
    }
}
