package workbook_0x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FlymetotheAlphaCentauri_1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d= y-x;
            int max = (int) Math.sqrt(d);

            if (max == Math.sqrt(d)){
                sb.append(max * 2-1);
            }else if( d <= max * max + max){
                sb.append(max*2);
            }else {
                sb.append(max*2+1);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
