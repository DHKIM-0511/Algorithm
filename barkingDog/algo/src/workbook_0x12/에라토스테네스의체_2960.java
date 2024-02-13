package workbook_0x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 에라토스테네스의체_2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        boolean[] a = new boolean[n+1];
        for(int i = 2; i <= n ; i++){
            if(a[i]) continue;
            for(int j = i ; j <= n ; j +=i ){
                if(a[j]) continue;
                a[j] = true;
                k--;
                if (k == 0) {
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}
