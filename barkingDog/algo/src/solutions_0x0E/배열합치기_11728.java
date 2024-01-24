package solutions_0x0E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열합치기_11728 {
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i++) B[i] = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        int aidx=0, bidx=0;
        for(int i = 0 ; i < N +M ; i++){
            if(bidx == M) sb.append(A[aidx++]).append(" ");
            else if(aidx == N) sb.append(B[bidx++]).append(" ");
            else if(A[aidx] <= B[bidx]) sb.append(A[aidx++]).append(" ");
            else sb.append(B[bidx++]).append(" ");
        }

        System.out.println(sb);
    }
}
