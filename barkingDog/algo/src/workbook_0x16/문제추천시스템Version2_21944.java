package workbook_0x16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 문제추천시스템Version2_21944 {
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        TreeSet<Problem> set = new TreeSet<>(new Comparator<Problem>() {
            @Override
            public int compare(Problem o1, Problem o2) {
                if(o1.p == o2.p) return o1.l - o2.l;
                return o1.p - o2.p;
            }
        });
        n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int p= Integer.parseInt(st.nextToken());
            int l= Integer.parseInt(st.nextToken());
            int g= Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
    }
    static class Problem{
        int p,l,g;
        Problem(int p, int l, int g){
            this.p = p;
            this.l = l;
            this.g = g;
        }
    }
}
