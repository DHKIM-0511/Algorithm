package solutions_0x1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 음악프로그램_2623 {
    static int n,m;
    static List<List<Integer>> adjList = new ArrayList<>();
    static int[] indeg;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0 ;i < 3; i++){
            st = new StringTokenizer(br.readLine());
            int pre = -1;
            while (st.hasMoreTokens()){
                int cur = Integer.parseInt(st.nextToken());
                if(pre == -1){
                    pre = cur;
                }else{
                    adjList.get(pre).add(cur);
                    indeg[cur]++;
                }
            }
        }


    }
}
