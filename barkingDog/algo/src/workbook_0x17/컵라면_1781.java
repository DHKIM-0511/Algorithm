package workbook_0x17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 컵라면_1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<List<Integer>> probList = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0 ; i <= 200001; i++) probList.add(new ArrayList<>());

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            probList.get(d).add(c);
        }

        long cnt = 0;
        for (int i = 200001 ; i > 0 ; i--){
            for(int c : probList.get(i)){
                pq.add(c);
            }

            if(!pq.isEmpty()){
                cnt += pq.poll();
            }
        }

        System.out.println(cnt);
    }
}
