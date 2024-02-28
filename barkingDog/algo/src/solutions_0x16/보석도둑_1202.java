package solutions_0x16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 보석도둑_1202 {
    static int n,k;
    static List<Jewel> jewel = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //보석 수
        k = Integer.parseInt(st.nextToken()); // 가방 수
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewel.add(new Jewel(w,v));
        }
        Collections.sort(jewel, new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                return o2.v-o1.v;
            }
        });

        PriorityQueue<Integer> bags = new PriorityQueue<>();
        for(int i = 0 ; i < k ; i++){
            int w = Integer.parseInt(br.readLine());
            bags.offer(w);
        }

        long sum = 0;
        while (!bags.isEmpty() && !jewel.isEmpty()){
            int cur = bags.poll();
            for(Jewel j : jewel){
                if (cur >= j.w){
                    sum += j.v;
                    jewel.remove(j);
                    break;
                }
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
