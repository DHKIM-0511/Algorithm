package workbook_0x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 방번호_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String roomNum = br.readLine();

        int[] numbers = new int[10]; // 은진이가 파는 숫자 0~9

        for(int i = 0 ; i < roomNum.length(); i ++){
            char c = roomNum.charAt(i);
            numbers[c-'0']++;
        }
        int num = Math.round((float) (numbers[6]+ numbers[9])/2);
        numbers[6]= num;
        numbers[9]= num;

        int max = 0 ;
        for(int i : numbers) max = Math.max(max,i);
        System.out.println(max);
    }
}
