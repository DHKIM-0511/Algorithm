package solutions_0x16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 보석도둑_1202_ans {
    static int n,k;
    static Jewel[] jewel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //보석 수
        k = Integer.parseInt(st.nextToken()); // 가방 수
        jewel = new Jewel[n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewel[i]=new Jewel(w,v);
        }
        Arrays.sort(jewel, new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                return o1.w-o2.w;
            }
        });

        int[] bags = new int[k];
        for(int i = 0 ; i < k ; i++){
            int w = Integer.parseInt(br.readLine());
            bags[i] = w;
        }
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
        long sum = 0;
        int idx = 0;
        for(int i = 0 ; i < k ; i++){
            while (idx < n){
                Jewel cur = jewel[idx];
                if(bags[i] < cur.w) break;
                pq.offer(cur.v);
                idx++;
            }
            if(!pq.isEmpty()){
                sum+= pq.poll();
            }
        }
        System.out.println(sum);
    }
    static class Jewel{
        int w,v;
        Jewel(int w, int v){
            this.w = w;
            this.v = v;
        }
    }
}
