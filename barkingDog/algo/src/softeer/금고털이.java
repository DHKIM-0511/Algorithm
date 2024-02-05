package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 금고털이 {
    static int W,N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> {
            return o2[1] - o1[1];
        });

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{w,p});
        }

        int ans=0;
        while (W > 0){
            int[] cur = pq.poll();

            if(W - cur[0] >= 0){
                W -= cur[0];
                ans += cur[1] * cur[0];
            }else{
                ans += cur[1] * W;
                break;
            }
        }
        System.out.println(ans);
    }
}
