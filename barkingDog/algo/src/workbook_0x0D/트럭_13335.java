package workbook_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트럭_13335 {
    static int N,W,L,ans;
    static Queue<Integer> truckQueue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()){
            truckQueue.offer(Integer.parseInt(st.nextToken()));
        }
        int sum = 0;
        while (!truckQueue.isEmpty()){
            int w = truckQueue.poll();
            sum+=w;

            if(L >= sum){
                ans += w;
            }else{
                ans++;
            }
        }

        System.out.println(ans);
    }
}
