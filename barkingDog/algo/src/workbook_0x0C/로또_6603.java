package workbook_0x0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 로또_6603 {
    static int K;
    static StringBuilder sb = new StringBuilder();
    static boolean[] isUsed = new boolean[13];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> setNumbers = new ArrayList<>();

            K = Integer.parseInt(st.nextToken());
            if(K == 0) break;

            while (st.hasMoreTokens()){
                int tmp = Integer.parseInt(st.nextToken());
                setNumbers.add(tmp);
            }

            fnc(setNumbers, 0, 0, new int[6]);

            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void fnc(List<Integer> setNumbers, int cnt, int last, int[] numbers) {
        if(cnt == 6){
            for(int i: numbers) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for(int i =last  ; i < setNumbers.size() ; i++){
            if(isUsed[i])continue;
            isUsed[i] = true;
            numbers[cnt] = setNumbers.get(i);
            fnc(setNumbers, cnt+1, i+1, numbers);
            isUsed[i] = false;
        }
    }
}
