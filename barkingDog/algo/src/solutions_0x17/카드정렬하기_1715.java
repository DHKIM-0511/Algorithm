package solutions_0x17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드정렬하기_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n =  Integer.parseInt(br.readLine());
        for (int i = 0 ; i < n ; i++){
            int cur = Integer.parseInt(br.readLine());
            pq.offer(cur);
        }

        int sum  = 0;
        while (pq.size()>=2){
            int a = pq.poll();
            int b = pq.poll();
            sum += a+b;
            pq.offer(a+b);
        }
        System.out.println(sum);
    }
}
