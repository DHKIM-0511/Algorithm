package workbook_0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 숨바꼭질3_13549 {
    static int N,K,ans;
    static int[] d = {-1,1,2};
    static int[] map = new int[100001];
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        bfs();
        System.out.println(ans);
    }

    static void bfs() {
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);
        Arrays.fill(map, Integer.MAX_VALUE);

        map[N] = 0;
        q.offer(new Node(N,map[N]));

        while (!q.isEmpty()){
            Node cur = q.poll();

            if(visited[cur.i]) continue;
            visited[cur.i] = true;
            map[cur.i] = cur.d;

            if(cur.i == K){
                ans = cur.d;
                return;
            }

            for(int i = 0 ; i < 3; i++){
                int ni = i == 2 ? cur.i*d[i] : cur.i+d[i];

                if(ni < 0 || ni >= 100001) continue;
                q.offer(new Node(ni, i == 2 ? cur.d : cur.d+1));
            }
        }
    }
    static class Node{
        int i,d;
        public Node(int i, int d){
            this.i=i;
            this.d=d;
        }
    }
}
