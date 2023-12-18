package workbook_0x07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 회전하는큐_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<Integer>();

        int count = 0;	// 2, 3번 연산 횟수 누적 합 변수

        for(int i = 1 ; i<= N ; i++){
            deque.offer(i);
        }
        int[] seq = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < M ; i++){
            int target = deque.indexOf(seq[i]);
            int half;

            if(deque.size() % 2 == 0){
                half = deque.size()/2 - 1;
            }else{
                half = deque.size()/2;
            }

            if(target <= half){
                for(int j = 0 ; j < target; j ++){
                    int dum = deque.pollFirst();
                    deque.offerLast(dum);
                    count++;
                }
            }else{
                for(int j = 0 ; j < deque.size() - target; j++){
                    int dum = deque.pollLast();
                    deque.offerFirst(dum);
                    count++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(count);
    }
}
