package workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2024_easy_12100 {
    static int n,ans;
    static int[][] map,copyMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        copyMap = new int[n][n];
        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        setDir(0, new int[5]);
        System.out.println(ans);
    }

    private static void setDir(int cnt, int[] sel) {
        if(cnt == 5){
            copyMap();
            move(sel);
            getMaxValue();
            return;
        }

        for(int i = 0 ; i < 4 ; i++){
            sel[cnt] = i;
            setDir(cnt+1, sel);
        }
    }

    private static void getMaxValue() {
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                ans = Math.max(copyMap[i][j] , ans);
            }
        }
    }

    private static void move(int[] dirArr) {

        for(int dir : dirArr){
            if(dir == 0){ // 상
                for(int i = 0 ; i < n ; i++){
                    int[] tmp = new int[n];
                    int idx = 0;

                    for(int j = 0 ; j < n ; j++){
                        if(copyMap[j][i] == 0) continue;
                        if(tmp[idx] == 0){
                            tmp[idx] = copyMap[j][i];
                        } else if (tmp[idx] == copyMap[j][i]) {
                            tmp[idx] *= 2;
                            idx++;
                        }else {
                            idx++;
                            tmp[idx] = copyMap[j][i];
                        }
                    }

                    for(int j = 0 ; j < n ; j++){
                        copyMap[j][i] = tmp[j];
                    }
                }


            }else if(dir == 1){ // 하
                for(int i = 0 ; i < n ; i++){
                    int[] tmp = new int[n];
                    int idx = 0;

                    for(int j = n-1 ; j >=0  ; j--){
                        if(copyMap[j][i] == 0) continue;
                        if(tmp[idx] == 0){
                            tmp[idx] = copyMap[j][i];
                        } else if (tmp[idx] == copyMap[j][i]) {
                            tmp[idx] *= 2;
                            idx++;
                        }else {
                            idx++;
                            tmp[idx] = copyMap[j][i];
                        }
                    }
                    idx=0;
                    for(int j = n-1 ; j >= 0 ; j--){
                        copyMap[j][i] = tmp[idx++];
                    }
                }

            }else if(dir == 2){ //좌
                for(int i = 0 ; i < n ; i++){
                    int[] tmp = new int[n];
                    int idx = 0;

                    for(int j = 0 ; j < n ; j++){
                        if(copyMap[i][j] == 0) continue;
                        if(tmp[idx] == 0){
                            tmp[idx] = copyMap[i][j];
                        } else if (tmp[idx] == copyMap[i][j]) {
                            tmp[idx] *= 2;
                            idx++;
                        }else {
                            idx++;
                            tmp[idx] = copyMap[i][j];
                        }
                    }

                    for(int j = 0 ; j < n ; j++){
                        copyMap[i][j] = tmp[j];
                    }
                }
            }else { // 우
                for(int i = 0 ; i < n ; i++){
                    int[] tmp = new int[n];
                    int idx = 0;

                    for(int j = n-1 ; j >= 0 ; j--){
                        if(copyMap[i][j] == 0) continue;
                        if(tmp[idx] == 0){
                            tmp[idx] = copyMap[i][j];
                        } else if (tmp[idx] == copyMap[i][j]) {
                            tmp[idx] *= 2;
                            idx++;
                        }else {
                            idx++;
                            tmp[idx] = copyMap[i][j];
                        }
                    }
                    idx = 0;
                    for(int j = n-1 ; j >= 0 ; j--){
                        copyMap[i][j] = tmp[idx++];
                    }
                }
            }

        }
    }

    private static void copyMap() {
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j <n ; j++){
                copyMap[i][j] = map[i][j];
            }
        }
    }
}
