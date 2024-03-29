package workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 큐빙_5373 {
    static char[][] upperCube = new char[3][3];
    static char[][] downCube = new char[3][3];
    static char[][] leftCube = new char[3][3];
    static char[][] rightCube = new char[3][3];
    static char[][] frontCube = new char[3][3];
    static char[][] behindCube = new char[3][3];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (tc -- > 0){
            paintCube();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++){
                String s = st.nextToken();
                rotate(s);
            }
            printUpper();

        }
        System.out.println(sb);
    }

    private static void printUpper() {
        for(char[] c : upperCube){
            for(char cc: c){
                sb.append(cc);
            }
            sb.append("\n");
        }
    }

    private static void rotate(String s) {
        char c1 = s.charAt(0);
        char c2 = s.charAt(1);
        char[] tmp;

        if(c2 == '+'){
            if(c1 == 'U'){
                turn(upperCube);
                tmp = new char[]{frontCube[0][0],frontCube[0][1],frontCube[0][2]};
                for(int i = 0 ; i < 3; i++){
                    frontCube[0][i] = rightCube[0][i];
                    rightCube[0][i] = behindCube[2][2-i];
                    behindCube[2][2-i] = leftCube[0][i];
                    leftCube[0][i] = tmp[i];
                }
            } else if (c1 == 'D') {
                turn(downCube);
                tmp = new char[]{frontCube[2][0],frontCube[2][1],frontCube[2][2]};
                for(int i = 0 ; i < 3; i++){
                    frontCube[2][i] = leftCube[2][i];
                    leftCube[2][i] = behindCube[0][2-i];
                    behindCube[0][2-i] = rightCube[2][i];
                    rightCube[2][i] = tmp[i];
                }
            } else if (c1 == 'F') {
                turn(frontCube);
                tmp = new char[]{upperCube[2][0],upperCube[2][1],upperCube[2][2]};
                for(int i = 0 ; i < 3; i++){
                    upperCube[2][i] = leftCube[2-i][2];
                    leftCube[2-i][2] = downCube[0][2-i];
                    downCube[0][2-i] = rightCube[i][0];
                    rightCube[i][0] = tmp[i];
                }
            } else if (c1 == 'B') {
                turn(behindCube);
                tmp = new char[]{upperCube[0][0],upperCube[0][1],upperCube[0][2]};
                for(int i = 0 ; i < 3; i++){
                    upperCube[0][i] = rightCube[i][2];
                    rightCube[i][2] = downCube[2][2-i];
                    downCube[2][2-i] = leftCube[2-i][0];
                    leftCube[2-i][0] = tmp[i];
                }
            } else if (c1 == 'L') {
                turn(leftCube);
                tmp = new char[]{upperCube[0][0],upperCube[1][0],upperCube[2][0]};
                for(int i = 0 ; i < 3; i++){
                    upperCube[i][0] = behindCube[i][0];
                    behindCube[i][0] = downCube[i][0];
                    downCube[i][0] = frontCube[i][0];
                    frontCube[i][0] = tmp[i];
                }
            } else {
                turn(rightCube);
                tmp = new char[]{upperCube[0][2],upperCube[1][2],upperCube[2][2]};
                for(int i = 0 ; i < 3; i++){
                    upperCube[i][2] = frontCube[i][2];
                    frontCube[i][2] = downCube[i][2];
                    downCube[i][2] = behindCube[i][2];
                    behindCube[i][2] = tmp[i];
                }
            }

        }else {
            int rot = 3;
            while (rot-- >0){
                if(c1 == 'U'){
                    turn(upperCube);
                    tmp = new char[]{frontCube[0][0],frontCube[0][1],frontCube[0][2]};
                    for(int i = 0 ; i < 3; i++){
                        frontCube[0][i] = rightCube[0][i];
                        rightCube[0][i] = behindCube[2][2-i];
                        behindCube[2][2-i] = leftCube[0][i];
                        leftCube[0][i] = tmp[i];
                    }
                } else if (c1 == 'D') {
                    turn(downCube);
                    tmp = new char[]{frontCube[2][0],frontCube[2][1],frontCube[2][2]};
                    for(int i = 0 ; i < 3; i++){
                        frontCube[2][i] = leftCube[2][i];
                        leftCube[2][i] = behindCube[0][2-i];
                        behindCube[0][2-i] = rightCube[2][i];
                        rightCube[2][i] = tmp[i];
                    }
                } else if (c1 == 'F') {
                    turn(frontCube);
                    tmp = new char[]{upperCube[2][0],upperCube[2][1],upperCube[2][2]};
                    for(int i = 0 ; i < 3; i++){
                        upperCube[2][i] = leftCube[2-i][2];
                        leftCube[2-i][2] = downCube[0][2-i];
                        downCube[0][2-i] = rightCube[i][0];
                        rightCube[i][0] = tmp[i];
                    }
                } else if (c1 == 'B') {
                    turn(behindCube);
                    tmp = new char[]{upperCube[0][0],upperCube[0][1],upperCube[0][2]};
                    for(int i = 0 ; i < 3; i++){
                        upperCube[0][i] = rightCube[i][2];
                        rightCube[i][2] = downCube[2][2-i];
                        downCube[2][2-i] = leftCube[2-i][0];
                        leftCube[2-i][0] = tmp[i];
                    }
                } else if (c1 == 'L') {
                    turn(leftCube);
                    tmp = new char[]{upperCube[0][0],upperCube[1][0],upperCube[2][0]};
                    for(int i = 0 ; i < 3; i++){
                        upperCube[i][0] = behindCube[i][0];
                        behindCube[i][0] = downCube[i][0];
                        downCube[i][0] = frontCube[i][0];
                        frontCube[i][0] = tmp[i];
                    }
                } else {
                    turn(rightCube);
                    tmp = new char[]{upperCube[0][2],upperCube[1][2],upperCube[2][2]};
                    for(int i = 0 ; i < 3; i++){
                        upperCube[i][2] = frontCube[i][2];
                        frontCube[i][2] = downCube[i][2];
                        downCube[i][2] = behindCube[i][2];
                        behindCube[i][2] = tmp[i];
                    }
                }
            }
        }
    }

    private static void turn(char[][] cube) {
        char[][] tmp = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tmp[j][3 - i - 1] = cube[i][j];
            }
        }
        copyMap(tmp, cube);
    }

    private static void copyMap(char[][] tmp, char[][] map) {
        for (int i = 0; i < 3; i++) {
            System.arraycopy(tmp[i], 0, map[i], 0, 3);
        }
    }

    private static void paintCube() {
        for(int i = 0; i < 3 ; i++){
            for(int j =0; j < 3 ; j++){
                upperCube[i][j] = 'w';
                downCube[i][j] = 'y';
                leftCube[i][j] = 'g';
                rightCube[i][j] = 'b';
                frontCube[i][j] = 'r';
                behindCube[i][j] = 'o';
            }
        }
    }
}

