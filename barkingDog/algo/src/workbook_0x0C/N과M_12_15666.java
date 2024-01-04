package workbook_0x0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class N과M_12_15666 {
    static int N,M;
    static List<Integer> setNumbers;
    static boolean[] check = new boolean[10000];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        setNumbers = new ArrayList<>();

        int idx = 0;
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            if(setNumbers.contains(num))continue;
            setNumbers.add(num);
        }
        Collections.sort(setNumbers);

        fnc(0, 0, new int[M]);
        System.out.println(sb);
    }

    private static void fnc(int cnt, int last, int[] numbers) {
        if(cnt ==M){
            for(int i : numbers) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = last ; i < setNumbers.size() ; i++){
            numbers[cnt] = setNumbers.get(i);
            fnc(cnt + 1, i, numbers);
        }
    }
}
