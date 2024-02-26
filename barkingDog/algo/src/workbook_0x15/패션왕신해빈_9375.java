package workbook_0x15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 패션왕신해빈_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0){
            Map <String, Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for(int i = 0 ; i < n ; i++){
                st = new StringTokenizer(br.readLine());
                String cloth = st.nextToken();
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 0)+1);
                }
            int ans = 1;
            for (int i : map.values()){
                ans *= i+1;
            }
            sb.append(ans-1).append("\n");
        }
        System.out.println(sb);
    }
}
