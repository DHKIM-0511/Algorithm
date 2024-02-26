package workbook_0x15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 비밀번호찾기_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();
        while (n-- >0){
            st = new StringTokenizer(br.readLine());
            String path = st.nextToken();
            String pw = st.nextToken();
            map.put(path, pw);
        }
        StringBuilder sb = new StringBuilder();
        while (m-- > 0){
            sb.append(map.get(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }
}
