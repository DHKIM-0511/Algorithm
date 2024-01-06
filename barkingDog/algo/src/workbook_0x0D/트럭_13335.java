package workbook_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트럭_13335 {
    static int N,W,L,ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int[] trucks = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) trucks[i] = Integer.parseInt(st.nextToken());

        Queue<Integer> bridge = new LinkedList<>();
        for(int i = 0 ; i < W ; i++) bridge.offer(0);

        int truckIdx = 0;
        int totalWeight = 0;

        while (truckIdx < N){
            int cur = trucks[truckIdx];

            ans++;
            totalWeight -= bridge.poll();
            if(totalWeight + cur > L){
                bridge.offer(0);
            }else{
                bridge.offer(cur);
                truckIdx++;
                totalWeight += cur;
            }
        }
        ans += W;
        System.out.println(ans);
    }
}
