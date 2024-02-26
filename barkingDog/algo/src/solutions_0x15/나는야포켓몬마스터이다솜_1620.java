package solutions_0x15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 나는야포켓몬마스터이다솜_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        HashMap<String, Integer> StringAndInt = new HashMap<>();
        String[] po = new String[n+1];

        for(int i = 1 ; i <= n ; i++){
            String cur = br.readLine();
            po[i] = cur;
            StringAndInt.put(cur, i);
        }
        StringBuilder sb = new StringBuilder();
        while (m-->0){
            String cur = br.readLine();

            if(cur.charAt(0)-'0' < 0 || cur.charAt(0)-'0' > 10){
                sb.append(StringAndInt.get(cur)).append("\n");
            }else{
                int i = Integer.parseInt(cur);
                sb.append(po[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
