package workbook_0x16;

import groovyjarjarantlr4.runtime.tree.Tree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 수업_19700 {
    static int[][] a = new int[500005][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0 ; i < n ; i++){
            Integer v = set.ceiling(-a[i][1]);
            if(v == null) set.add(-1);
            else {
                set.remove(v);
                set.add(v-1);
            }
        }
        System.out.println(set.size());
    }
}
