import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {
    static int[][] map;
    static int[][] copyMap = new int[5][5];
    public static void main(String[] args) throws IOException {
        // 5x5 2차원 배열 초기화
        map = new int[][]{
            {1, 1, 1, 1, 1},
            {2, 2, 2, 2, 2},
            {3, 3, 3, 3, 3},
            {4, 4, 4, 4, 4},
            {5, 5, 5, 5, 5}
        };

        // 초기 맵 출력
        System.out.println("Original map:");
        printMap(map);

        // 90도 회전
        copyMap();
        rotate(copyMap, 1);
        System.out.println("Rotated 90 degrees:");
        printMap(copyMap);

        // 180도 회전 (총 270도 회전)
        copyMap();
        rotate(copyMap, 2);
        System.out.println("Rotated 180 degrees (cumulative):");
        printMap(copyMap);

        // 270도 회전 (총 360도 회전, 원래 상태)
        copyMap();
        rotate(copyMap, 3);
        System.out.println("Rotated 270 degrees (cumulative):");
        printMap(copyMap);
    }
    private static void copyMap() {
        for(int j = 0 ; j < 5 ; j++){
            for(int k = 0 ; k < 5 ; k++){
                copyMap[j][k] = map[j][k];
            }
        }
    }
    private static void rotate(int[][] map, int dir){
        if(dir == 0) return;

        int[][] tmp = new int[5][5];
        if( dir == 1 ){
            //90도
            for(int i = 0 ; i < 5 ; i++){
                for(int j = 0 ; j < 5 ; j++){
                    tmp[i][j] = map[5-j-1][i];
                }
            }
        }else if(dir == 2){
            //180도
            for(int i = 0 ; i < 5 ; i++){
                for(int j = 0 ; j < 5 ; j++){
                    tmp[i][j] = map[5-i-1][5-j-1];
                }
            }
        }else{
            //270도
            for(int i = 0 ; i < 5 ; i++){
                for(int j = 0 ; j < 5 ; j++){
                    tmp[i][j] = map[j][5-i-1];
                }
            }
        }
        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j < 5; j++){
                map[i][j] = tmp[i][j];
            }
        }
    }
    private static void printMap(int[][] map) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
