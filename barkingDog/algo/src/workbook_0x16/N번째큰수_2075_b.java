package workbook_0x16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N번째큰수_2075_b {
    static int[][] map = new int[1502][1502];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> {
            return o2.v-o1.v;
        });

        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(i == n-1){
                    pq.offer(new Node(j, map[i][j]));
                }
            }
        }
        int[] row = new int[n];
        Arrays.fill(row, n-1);
        int ans = 0;
        while (n-- >0){
            Node cur = pq.poll();
            ans = cur.v;
            int idx = cur.idx;
            row[idx]--;

            if(row[idx] >= 0){
                pq.offer(new Node(idx, map[row[idx]][idx]));
            }
        }
        System.out.println(ans);
    }
    static class Node{
        int idx,v;
        Node(int idx, int v){
            this.idx = idx;
            this.v=v;
        }
    }
}
