package workbook_0x0F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class 단어정렬_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) return o1.length() - o2.length();
                return o1.compareTo(o2);
            }
        };

        Set<String> set = new TreeSet<>(c);
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (String str : set) {
            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }
}
