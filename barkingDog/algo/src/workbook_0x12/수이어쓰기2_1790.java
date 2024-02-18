package workbook_0x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수이어쓰기2_1790 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int l=1;
        long tmp =1;
        while (k > 9L * l * tmp){
            k -= 9 * l * tmp;
            tmp *= 10;
            l++;
        }

        int target = (int) tmp + (k-1) / l;
        if(target > n){
            System.out.println(-1);
        }else {
            System.out.println(String.valueOf(target).charAt((k - 1) % l));
        }
    }
}
