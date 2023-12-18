package workbook_0x02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 홀수_2576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = 0;
        int min = Integer.MAX_VALUE;
        boolean b = false;
        for(int i = 0 ; i < 7 ; i++){
            int cur = Integer.parseInt(br.readLine());

            if(cur % 2 != 0){
                b = true;
                total += cur;
                min = Math.min(min, cur);
            }
        }
        if(b){
            System.out.println(total);
            System.out.println(min);
        }else{
            System.out.println(-1);
        }
    }
}
