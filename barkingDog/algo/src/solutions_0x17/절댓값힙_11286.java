package solutions_0x17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 절댓값힙_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> {
            int a = Math.abs(o1);
            int b = Math.abs(o2);
            if(a == b) return o1-o2;
            return a - b;
        });

        int n =Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0){
            int cur = Integer.parseInt(br.readLine());
            if(cur == 0 ){
                if(pq.isEmpty())sb.append(0);
                else sb.append(pq.poll());
                sb.append("\n");
            }else {
                pq.offer(cur);
            }
        }
        System.out.println(sb);
    }
}
