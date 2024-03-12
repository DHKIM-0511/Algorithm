package workbook_0x1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 계보복원가호석_21276 {
    static int n,m;
    static List<List<Integer>> adjList = new ArrayList<>() , ch = new ArrayList<>();
    static String[] name;
    static int[] indeg;
    static HashMap<String, Integer> si = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        indeg = new int[n+1];
        name = new String[n+1];
        for(int i = 0 ; i <= n ; i++){
            adjList.add(new ArrayList<>());
            ch.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =1 ; i <= n ; i++) name[i] = st.nextToken();
        name[0]="a";
        Arrays.sort(name);

        for(int i = 1; i <= n ; i++) si.put(name[i],i );

        m = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            String x = st.nextToken();
            String y = st.nextToken();
            int ix = si.get(x);
            int iy = si.get(y);

            adjList.get(iy).add(ix);
            indeg[ix]++;
        }

        StringBuilder sb = getStringBuilder();
        System.out.println(sb);

    }

    private static StringBuilder getStringBuilder() {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= n ; i++){
            if(indeg[i] == 0) list.add(i);
        }
        sb.append(list.size()).append("\n");
        for (int i : list){
            sb.append(name[i]).append(" ");
        }
        sb.append("\n");

        for(int i = 1; i <= n ; i++){
            Collections.sort(adjList.get(i));
            for(int n : adjList.get(i)){
                if(indeg[n] - indeg[i] == 1) ch.get(i).add(n);
            }
        }
        for(int i = 1; i <= n ; i++){
            int sz = ch.get(i).size();
            sb.append(name[i]).append(" ").append(sz).append(" ");
            for(int n : ch.get(i)){
                sb.append(name[n]).append(" ");
            }
            sb.append("\n");
        }

        return sb;
    }
}
