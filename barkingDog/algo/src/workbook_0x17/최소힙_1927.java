package workbook_0x17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 최소힙_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0){
            int cur = Integer.parseInt(br.readLine());
            if(cur == 0){
                if(pq.isEmpty()) sb.append(0);
                else sb.append(pq.poll());
                sb.append("\n");
            }else pq.offer(cur);
        }
        System.out.println(sb);
    }
}
