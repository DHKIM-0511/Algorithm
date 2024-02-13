package workbook_0x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GCD합_9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            List<Integer> list = new ArrayList<>();
            while (st.hasMoreTokens()) list.add(Integer.parseInt(st.nextToken()));

            long sum = 0;
            for(int i = 0 ; i < list.size()-1 ; i++){
                int a = list.get(i);
                for(int j = i+1 ; j < list.size() ; j++){
                    int b = list.get(j);
                    sum += gcd(a,b);
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
    static int gcd(int a,int b){
        if(a == 0) return b;
        return gcd(b%a, a);
    }
}
