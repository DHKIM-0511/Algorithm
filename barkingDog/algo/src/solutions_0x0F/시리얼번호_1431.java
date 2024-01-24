package solutions_0x0F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 시리얼번호_1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<char[]> input = new ArrayList<>();

        for(int i = 0 ; i < N ; i++){
            input.add(br.readLine().toCharArray());
        }

        Collections.sort(input, new Comparator<char[]>() {
            @Override
            public int compare(char[] o1, char[] o2) {
                if (o1.length != o2.length) return o1.length - o2.length;
                int sum1 = 0, sum2 = 0;
                for (int i = 0; i < o1.length; i++) {
                    if (o1[i] >= 48 && o1[i] <= 57) sum1 += o1[i] - 48;
                    if (o2[i] >= 48 && o2[i] <= 57) sum2 += o2[i] - 48;
                }
                if (sum1 != sum2) return Integer.compare(sum1, sum2);
                return new String(o1).compareTo(new String(o2));
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            for(char c : input.get(i)) sb.append(c);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
