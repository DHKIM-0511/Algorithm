package workbook_0x06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class 카드2_2146 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> dqDeque = new LinkedList<>();
        for(int i = 1 ; i <= N ; i++){
            dqDeque.offer(i);
        }

        while (dqDeque.size() != 1){
            dqDeque.removeFirst();
            int tmp = dqDeque.removeFirst();
            dqDeque.offer(tmp);
        }
        System.out.println(dqDeque.poll());
    }
}
