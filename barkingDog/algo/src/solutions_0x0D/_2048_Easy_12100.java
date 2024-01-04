package solutions_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2048_Easy_12100 {
    static int N,ans;
    static int[][] map = new int[25][25];
    static int[][] copyMap = new int[25][25];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int total = 1;
        for(int i = 0 ; i < 5 ; i ++) total *= 4;

        for(int i = 0 ; i < total ; i++){
            copyMap();

            int tmp = i;
            for(int j = 0 ; j < 5 ; j ++){
                int dir = tmp % 4;
                tmp/=4;

                tilt(dir);
            }
            getAns();
        }
        System.out.println(ans);
    }

    private static void tilt(int dir) {
        while ( dir -- > 0) copyMap = rotate();

        for(int i = 0 ; i < N ; i++){
            int[] arr = new int[21];
            int idx = 0;

            for(int j = 0 ; j < N ; j++){
                if(copyMap[i][j] == 0) continue;
                if(arr[idx] == 0){
                    arr[idx] = copyMap[i][j];
                }
                else if(arr[idx] == copyMap[i][j]){
                    arr[idx++] *= 2;
                }else{
                    arr[++idx] = copyMap[i][j];
                }
            }
            for(int j = 0 ; j < N ; j++){
                copyMap[i][j] = arr[j];
            }
        }
    }

    private static void getAns() {
        for(int[] i : copyMap){
            for(int j : i){
                ans = Math.max(ans, j);
            }
        }
    }

    private static int[][] rotate(){
        int[][] tmp = new int[21][21];

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                tmp [i][j] = copyMap[i][j];
            }
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                tmp[j][N - 1 - i] = copyMap[i][j];
            }
        }
        return tmp;
    }

    static void copyMap(){
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                copyMap[i][j] = map[i][j];
            }
        }
    }
}
