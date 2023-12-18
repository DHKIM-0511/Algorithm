package workbook_0x02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 별찍기_6_2443 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int l = 0;
        int r = 2*(N-1);

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < 2*N-1 ; j++){
                if(j > r) break;

                if(j < l){
                    sb.append(" ");
                }else{
                    sb.append("*");
                }
            }
            sb.append("\n");

            l++;
            r--;
        }
        System.out.println(sb);
    }
}
