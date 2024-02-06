package workbook_0x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 잃어버린괄호_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        boolean flag = false;
        if(input.charAt(0) == '-') flag = true;

        String[] arr = input.split("-");
        int sum = 0;
        for(int i = 0 ; i < arr.length ; i++){
            String[] num = arr[i].split("\\+");
            if(i == 0){
                if(flag) for(String s : num) sum -= Integer.parseInt(s);
                else for(String s : num) sum += Integer.parseInt(s);
            }else{
                int temp = 0;
                for(String s : num) temp+= Integer.parseInt(s);
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
