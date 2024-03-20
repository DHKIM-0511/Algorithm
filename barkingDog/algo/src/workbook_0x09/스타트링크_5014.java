package workbook_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스타트링크_5014 {
    static int f,s,g,u,d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        int[] a = {u,d*-1};

        Queue<Node> q= new LinkedList<>();
        q.offer(new Node(s,0));

        boolean[] visited = new boolean[f+1];
        visited[s] = true;

        int ans = -1;
        while (!q.isEmpty()){
            Node cur = q.poll();
            if(cur.idx == g){
                ans = cur.cnt;
                break;
            }
            for(int i = 0 ; i < 2; i ++){
                int n = cur.idx + a[i];

                if(n <= 0 || n > f || visited[n]) continue;
                q.offer(new Node(n, cur.cnt+1));
                visited[n] =true;
            }
        }
        if(ans == -1){
            System.out.println("use the stairs");
            return;
        }
        System.out.println(ans);
    }
    static class Node{
        int idx , cnt;
        Node(int idx, int cnt){
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}
