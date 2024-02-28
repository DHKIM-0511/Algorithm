package workbook_0x16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 문제추천시스템Version1_21939 {
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        TreeSet<Problem> problems = new TreeSet<>(new Comparator<Problem>() {
            @Override
            public int compare(Problem o1, Problem o2) {
                if(o1.l == o2.l) return o1.p - o2.p;
                return o1.l - o2.l;
            }
        });
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            problems.add(new Problem(p,l));
            map.put(p,l);
        }

        m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (m-- > 0){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if(s.charAt(0) == 'a'){
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                problems.add(new Problem(p,l));
                map.put(p,l);
            }else if (s.charAt(0) == 'r'){
                int x = Integer.parseInt(st.nextToken());
                if ( x == 1 )sb.append(problems.last().p);
                else sb.append(problems.first().p);
                sb.append("\n");
            }else {
                int p = Integer.parseInt(st.nextToken());
                problems.remove(new Problem(p,map.get(p)));
                map.remove(p);
            }
        }
        System.out.println(sb);
    }
    static class Problem{
        int p,l;
        Problem(int p, int l){
            this.p=p;
            this.l=l;
        }
    }
}
