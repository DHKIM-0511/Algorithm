package solutions_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달_15686 {
    static int N,M,ans = Integer.MAX_VALUE;
    static int[][] map = new int[50][50];
    static List<Node> chickenList = new ArrayList<>();
    static List<Node> customers = new ArrayList<>();
    static Node[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) chickenList.add(new Node(i,j,0));
                else if(map[i][j] == 1) customers.add(new Node(i,j,0));
            }
        }

        selected = new Node[M];
        select(0,0);
        System.out.println(ans);
    }

    private static void select(int cnt, int last) {
        if(cnt == M){
            ans = Math.min(getDistance(), ans);
            return;
        }

        for(int i = last ; i < chickenList.size() ; i++){
            selected[cnt] = chickenList.get(i);
            select(cnt+1, i+1);
        }
    }

    private static int getDistance() {
        int sum = 0;
        for(Node n : customers){
            int tmp = Integer.MAX_VALUE;

            for(Node chicken : selected){
                tmp = Math.min(tmp, Math.abs(n.r - chicken.r) + Math.abs(n.c - chicken.c));
            }
            sum += tmp;
        }
        return sum;
    }

    static class Node{
        int r,c,d;
        public Node(int r, int c,int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }
}
