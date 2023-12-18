package solutions_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 숨바꼭질_1697 {
    static int N,K,ans;
    static int[] dc = {-1,1,2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        N = Integer.parseInt(NK[0]);
        K = Integer.parseInt(NK[1]);

        int[] map = new int[100001];
        boolean[] visited = new boolean[100001];

        bfs(map,visited);
        System.out.println(ans);
    }
    static void bfs(int[] map, boolean[] visited){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(N,0));
        visited[N] = true;

        while (!q.isEmpty()){
            Node cur = q.poll();
            if(cur.c == K){
                ans = cur.t;
                return;
            }
            for(int i = 0 ; i < 3 ; i++){
                int next;
                if(i == 2){
                    next = cur.c * dc[i];
                }else{
                    next = cur.c + dc[i];
                }

                if(next < 0 || next > 100000) continue;
                if(visited[next] ) continue;

                q.offer(new Node(next, cur.t+1));
                visited[next] = true;
            }
        }
    }
    static class Node{
        int c,t;
        public Node(int c, int t){
            this.c = c;
            this.t = t;
        }
    }
}
