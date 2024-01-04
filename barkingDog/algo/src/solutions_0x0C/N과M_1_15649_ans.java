package solutions_0x0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N과M_1_15649_ans {
        static StringBuilder sb = new StringBuilder();
        static int N,M;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);

            fnc(0,new int[M], new boolean[N+1]);
            System.out.println(sb);
        }

    private static void fnc(int cnt, int[] numbers, boolean[] check) {
        if(cnt == M){
            for(int i : numbers) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = 1 ; i <= N ; i++){
            if(check[i]) continue;
            check[i] =true;
            numbers[cnt] = i;
            fnc(cnt+1,numbers, check);
            check[i] = false;
        }
    }
}
