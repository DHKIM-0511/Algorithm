package solutions_0x15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 회사에있는사람_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String a = st.nextToken();

            if(a.charAt(0) == 'e'){
                set.add(name);
            }else {
                set.remove(name);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String s: set) sb.append(s).append("\n");
        System.out.println(sb);
    }
}
