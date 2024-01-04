package workbook_0x0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N과M_2_15650 {
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        fnc(0, 1, new int[M]);
        System.out.println(sb);
    }

    private static void fnc(int cnt, int last, int[] numbers) {
        if(cnt == M){
            for(int i : numbers) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = last ; i <= N ; i++){
            numbers[cnt] = i;
            fnc(cnt+1, i+1, numbers);
        }
    }
}
