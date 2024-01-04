package workbook_0x0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_5_15654 {
    static int N,M;
    static int[] setNumbers;
    static boolean[] isUsed = new boolean[10000];
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        setNumbers = new int[N];
        st = new StringTokenizer(br.readLine());
        int idx =0;
        while (st.hasMoreTokens()) setNumbers[idx++] = Integer.parseInt(st.nextToken());
        Arrays.sort(setNumbers);

        fnc(0, new int[M]);
        System.out.println(sb);
    }

    private static void fnc(int cnt, int[] numbers ) {
        if(cnt == M){
            for(int i : numbers) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = 0 ; i < N ; i++){
            if(isUsed[setNumbers[i]])continue;

            isUsed[setNumbers[i]] =true;
            numbers[cnt] = setNumbers[i];
            fnc(cnt +1, numbers);
            isUsed[setNumbers[i]] = false;
        }
    }
}
