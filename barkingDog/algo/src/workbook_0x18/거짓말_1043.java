package workbook_0x18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 거짓말_1043 {
    static int n,m;
    static boolean[] people = new boolean[51];
    static List<List<Integer>> adjpeopleList = new ArrayList<>();
    static List<List<Integer>> partyToPeople = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n =Integer.parseInt(st.nextToken());
        m =Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        if(num == 0){
            System.out.println(m);
            return;
        }
        while (st.hasMoreTokens()) people[Integer.parseInt(st.nextToken())] = true;

        for(int i = 0 ; i <= n ; i++) adjpeopleList.add(new ArrayList<>());
        for(int i = 0 ; i <= m ; i++) partyToPeople.add(new ArrayList<>());

        for(int i = 1 ; i <= m ; i++){
            st = new StringTokenizer(br.readLine());
            int total = Integer.parseInt(st.nextToken());
            int pre = Integer.parseInt(st.nextToken());
            partyToPeople.get(i).add(pre);

            while (--total > 0){
                int n = Integer.parseInt(st.nextToken());
                partyToPeople.get(i).add(n);
                adjpeopleList.get(n).add(pre);
                adjpeopleList.get(pre).add(n);
                pre = n;
            }
        }
        bfs();
        int cnt = 0 ;
        for(int i = 1; i<= m ; i++){
            boolean flag = false;
            for(int j : partyToPeople.get(i)) if( people[j]) flag =true;
            if(!flag) cnt++;
        }
        System.out.println(cnt);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i <= n ; i++) if(people[i]) q.offer(i);

        while (!q.isEmpty()){
            int cur = q.poll();
            for(int n : adjpeopleList.get(cur)){
                if(people[n]) continue;
                q.offer(n);
                people[n] = true;
            }
        }
    }
}
