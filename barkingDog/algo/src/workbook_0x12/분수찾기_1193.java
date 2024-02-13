package workbook_0x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 분수찾기_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int i = 1;
        while (n > i) {
            n -= i;
            i++;
        }

        int num = n;
        int d = i+1 - n;

        if(i % 2 == 1) {
            int tmp = num;
            num = d;
            d = tmp;
        }
        System.out.println(num +"/"+ d);
    }
}
