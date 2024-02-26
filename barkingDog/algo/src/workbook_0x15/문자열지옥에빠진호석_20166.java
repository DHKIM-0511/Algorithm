package workbook_0x15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 문자열지옥에빠진호석_20166 {
    static String[] map = new String[12];
    static int n,m,k;
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1}, dc = {-1, 0, 1, -1, 1, -1, 0, 1};
    static Map<String, Integer> cntMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n ; i++) map[i] = br.readLine();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                dfs(i,j,String.valueOf(map[i].charAt(j)));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (k-- >0){
            String cur = br.readLine();
            sb.append(cntMap.getOrDefault(cur,0)).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int r, int c, String target) {
        cntMap.put(target, cntMap.getOrDefault(target, 0)+1);
        if(target.length() == 5) return;
        for(int i = 0 ; i < 8 ; i++){
            int nr = (r + dr[i] + n) %n;
            int nc = (c + dc[i] + m) %m;
            dfs(nr,nc,target+map[nr].charAt(nc));
        }
    }
}
