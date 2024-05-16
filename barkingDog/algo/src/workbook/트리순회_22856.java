package workbook;

import java.io.*;
import java.util.*;

public class 트리순회_22856 {
    static int n;
    static int[] lc, rc, p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        lc = new int[n+1];
        rc = new int[n+1];
        p = new int[n+1];
        boolean[] vis = new boolean[n+1];

        Arrays.fill(p,-1);

        StringTokenizer st;
        for(int i = 1; i<= n ; i++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());


            lc[idx] = l;
            rc[idx] = r;

            if(l != -1)p[l] = idx;
            if(r != -1)p[r] = idx;
        }

        int end = 1;
        while (rc[end] != -1) end = rc[end];

        int cur = 1;
        int cnt = 0;

        while (true){
            vis[cur] = true;
            cnt++;

            if(lc[cur] != -1 && !vis[lc[cur]]){
                cur = lc[cur];
            }else if(rc[cur] != -1 && !vis[rc[cur]]){
                cur = rc[cur];
            }else{
                if(cur == end) break;
                else cur = p[cur];
            }
        }

        System.out.println(cnt-1);
    }
}
