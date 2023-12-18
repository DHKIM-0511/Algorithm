package workbook_0x02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 윷놀이_2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] 윷 = {"E","A","B","C","D"};
        for(int i = 0 ; i < 3 ; i++){
            String[] input = br.readLine().split(" ");

            int cnt = 4;
            for(String str: input){
                if(str.equals("1")) cnt--;
            }
            System.out.println(윷[cnt]);
        }
    }
}
