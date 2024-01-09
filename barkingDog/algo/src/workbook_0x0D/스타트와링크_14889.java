package workbook_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스타트와링크_14889 {
    static int N,ans = Integer.MAX_VALUE;
    static int[][] map = new int[21][21];
    static boolean[] teamStart = new boolean[21];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        setTeam(0,0);
        System.out.println(ans);
    }

    private static void setTeam(int cnt, int last) {
        if(cnt == N/2){
            calculate();
            return;
        }
        for(int i = last ; i < N ; i++){
            if(teamStart[i]) continue;
            teamStart[i] = true;
            setTeam(cnt +1, i +1);
            teamStart[i] = false;
        }
    }

    private static void calculate() {
        int startStatus = 0;
        int linkStatus = 0;

        for(int i = 0 ; i < N-1 ; i++){
            for(int j = i +1 ; j < N ; j++){
                if(teamStart[i] && teamStart[j]){
                    startStatus += map[i][j];
                    startStatus += map[j][i];
                }else if(!teamStart[i] && !teamStart[j]){
                    linkStatus += map[i][j];
                    linkStatus += map[j][i];
                }
            }
        }
        ans = Math.min(ans,Math.abs(startStatus - linkStatus));
    }
}
