package workbook_0x17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 가운데를말해요_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((o1,o2) -> {
            return o2-o1;
        });

        StringBuilder sb = new StringBuilder();
        while (n--> 0){
            int cur = Integer.parseInt(br.readLine());

            if(min.size() >= max.size()) max.offer(cur);
            else min.offer(cur);
            if(!min.isEmpty() && min.peek() < max.peek()){
                int a = max.poll();
                int b = min.poll();
                min.offer(a);
                max.offer(b);
            }
            sb.append(max.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
