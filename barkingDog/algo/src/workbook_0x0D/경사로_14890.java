package workbook_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 경사로_14890 {
    static int N,L;
    static int[][] map = new int[101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        // 가로
        for (int i = 0; i < N; i++){
            ArrayList<Integer> line = new ArrayList<>();
            for(int j = 0; j < N; j++) line.add(map[i][j]);
            if (check(line)) ans++;
        }

        // 세로
        for (int i = 0; i < N; i++){
            ArrayList<Integer> line = new ArrayList<>();
            for(int j = 0; j < N; j++) line.add(map[j][i]);
            if (check(line)) ans++;
        }
        System.out.println(ans);
    }
    private static boolean check(ArrayList<Integer> line) {
        int idx = 0;
        int cnt = 1;
        while (idx <  N - 1){
            if(Math.abs(line.get(idx) - line.get(idx+1)) > 1) return false;
            if(line.get(idx).equals(line.get(idx+1))){ // 평지
                cnt++;
                idx++;
            }else if(line.get(idx) < line.get(idx+1)){ // 오르막
                if(cnt < L) return false;
                cnt = 1;
                idx++;
            }else{ // 내리막
                if( idx + L >= N) return false;
                for(int i = idx +1 ; i < idx + L ; i++){
                    if(!line.get(i).equals(line.get(i+1)))return false;
                }
                idx += L;
                cnt=0;
            }
        }
        return true;
    }
}
