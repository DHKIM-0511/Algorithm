package workbook_0x1C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 가운데에서만나기_21940 {
    static final int INF=0x3f3f3f3f;
    static int n,m,p;
    static int[] input;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        for(int i = 1 ; i <= n ; i++){
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }
        for(int i = 0 ; i <m ; i++){
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());

            map[a][b] = Math.min(map[a][b],c);
        }

        p = Integer.parseInt(br.readLine());
        input = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < p ; i++) input[i] = Integer.parseInt(st.nextToken());

        for(int k = 1 ; k <= n ; k++){
            for(int i = 1 ; i<= n ; i++){
                for(int j = 1; j <= n ; j++){
                    int d = map[i][k] + map[k][j];
                    if(map[i][j] > d){
                        map[i][j] = d;
                    }
                }
            }
        }
        //도시별 최대 왕복 시간을 구함
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 1 ; i <= n ; i++){
            int time = 0;
            for(int j = 0 ; j < p; j++){
                time = Math.max(time, map[i][input[j]] + map[input[j]][i]);
            }
            list.add(new int[]{time, i});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])return o1[1] - o2[1];
                return o1[0]-o2[0];
            }
        });

        //그 중 최소 X를 구함
        int min = list.get(0)[0];
        StringBuilder sb = new StringBuilder();
        for(int[] i : list){
            if(min < i[0]) break;
            sb.append(i[1]).append(" ");
        }
        System.out.println(sb);
    }
}
