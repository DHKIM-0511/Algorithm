package solutions_0x16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 이중우선순위큐_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- >0){
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for(int i = 0 ; i < n ; i++){
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                int v = Integer.parseInt(st.nextToken());

                if(s.equals("I")){
                    map.put(v, map.getOrDefault(v,0)+1);
                }else{
                    if(map.isEmpty()) continue;
                    int key;
                    if(v == 1) key = map.lastKey();
                    else key = map.firstKey();

                    int val = map.get(key);
                    if(val - 1 == 0) map.remove(key);
                    else map.put(key, val-1);
                }
            }
            if(map.isEmpty()) sb.append("EMPTY");
            else sb.append(map.lastKey()).append(" ").append(map.firstKey());
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
