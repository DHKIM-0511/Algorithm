package workbook_0x02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별찍기_3_2440 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int r = N;

        StringBuilder sb= new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(j < r){
                    sb.append("*");
                }else{
                    break;
                }
            }
            sb.append("\n");
            r--;
        }
        System.out.print(sb);
    }
}
