package workbook_0x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 톱니바퀴_14891 {
    static List<Integer> gears = new LinkedList<>();
    static int[][] turns = new int[100][2];
    static int K;
    static boolean[] isUsed = new boolean[5];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0 ; i < 4; i++){
            String input = br.readLine();

            for(char c : input.toCharArray()){
                gears.add(c-'0');
            }
        }

        K = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < K ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            turns[i][0] = Integer.parseInt(st.nextToken());
            turns[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < K ; i++){
            int gearNum = turns[i][0];
            int dir = turns[i][1];
            isUsed = new boolean[5];
            turnGear(gearNum, dir);
        }

        System.out.println(getScore());
    }

    private static void turnGear(int gearNum, int dir){
        int firstIdx = (gearNum - 1) * 8;
        int lastIdx = 8 * gearNum - 1;

        int l1 = 8* (gearNum - 1) - 6 < 0 ? -1 : 8* (gearNum - 1) - 6;
        int l2 = 8* gearNum -2;
        int r1 = 8* gearNum -6;
        int r2 = 8* (gearNum + 1) - 2 >= 32 ? -1 : 8* (gearNum + 1) - 2;

        boolean left = l1 != -1 && gears.get(l1) != gears.get(l2);
        boolean right = r2 != -1 && gears.get(r1) != gears.get(r2);

        if(dir == 1){
            //시계 방향
            int last = gears.remove(lastIdx);
            gears.add(firstIdx, last);
        }else{
            //반시계 방향
            int first = gears.remove(firstIdx);
            gears.add(lastIdx, first);
        }

        isUsed[gearNum] =true;

        if(gearNum != 1 && left && !isUsed[gearNum-1]){
            turnGear(gearNum-1, dir * -1);
        }
        if (gearNum != 4 && right && !isUsed[gearNum+1]){
            turnGear(gearNum+1, dir * -1);
        }
    }
    private static int getScore() {
        int sum = 0;
        for(int i = 0 ; i < 4 ; i++){
            sum += gears.get(i*8) * Math.pow(2,i);
        }
        return sum;
    }
}
