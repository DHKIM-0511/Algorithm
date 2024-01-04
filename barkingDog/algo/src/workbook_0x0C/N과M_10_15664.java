package workbook_0x0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class N과M_10_15664 {
    static int N,M;
    static int[] setNumbers;
    static boolean[] isUsed = new boolean[10];
    static LinkedHashSet<String> set = new LinkedHashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N =Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());
        setNumbers = new int[N];

        int idx = 0;
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()){
            setNumbers[idx++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(setNumbers);

        fnc(0, 0, new int[M]);
        set.forEach(System.out::println);
    }

    private static void fnc(int cnt, int last,  int[] numbers) {
        if(cnt == M){
            StringBuilder sb = new StringBuilder();

            for(int i : numbers) sb.append(i).append(" ");
            set.add(sb.toString());
            return;
        }

        for(int i = last ; i < N ; i++){
            if(isUsed[i]) continue;

            isUsed[i] = true;
            numbers[cnt] = setNumbers[i];
            fnc(cnt+1, i, numbers);
            isUsed[i] = false;
        }
    }
}
