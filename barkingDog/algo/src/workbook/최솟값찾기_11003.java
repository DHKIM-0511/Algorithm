package workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최솟값찾기_11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n ; i++)arr[i] = Integer.parseInt(st.nextToken());

        int[] d = new int[n+1];
        d[1] = arr[1];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(d[1]);

        int l = 1;
        int r = 2;
        while (l <= n){



            r++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i : d){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
