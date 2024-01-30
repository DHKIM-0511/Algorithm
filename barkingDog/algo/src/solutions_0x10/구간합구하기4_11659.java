package solutions_0x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 구간합구하기4_11659 {
    static int N,M;
    static int[] num = new int[100005];
    static int[] memo = new int[100005];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++) num[i] = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        List <Node> list = new ArrayList<>();
        int max = 0;
        for(int m = 0 ; m < M ; m++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            max = Math.max(max, j);
            list.add(new Node(i,j));
        }
        memo[1] = num[1];
        for(int i = 2; i <= max ; i++){
            memo[i] = memo[i-1]+num[i];
        }
        for(Node n : list){
            sb.append(memo[n.j] - memo[n.i-1]).append("\n");
        }

        System.out.println(sb);
    }
    static class Node{
        int i,j;
        public Node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}
