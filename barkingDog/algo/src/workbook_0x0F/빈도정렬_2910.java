package workbook_0x0F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 빈도정렬_2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        List<Node> input = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            int cur = Integer.parseInt(st.nextToken());

            boolean check = false;
            for(Node n : input){
                if(n.v == cur){
                    check = true;
                    n.c += 1;
                    break;
                }
            }
            if(!check) input.add(new Node(cur,1));
        }

        Collections.sort(input, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.c - o1.c;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(Node n : input){
            for(int i = 0 ; i < n.c ; i++) sb.append(n.v).append(" ");
        }
        System.out.println(sb);
    }
    static class Node{
        int v,c;
        public Node(int v,int c){
            this.v = v;
            this.c = c;
        }
    }
}
