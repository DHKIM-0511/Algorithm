package workbook_0x02;

import java.io.IOException;
import java.util.Scanner;

public class 별찍기_9_2446 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = 2 * n - 1;
        int l = 0;
        int r = m;

        for(int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < l ; j++){
                System.out.print(" ");
            }
            for(int j = l ; j < r ; j++){
                System.out.print("*");
            }
            System.out.println();
            if(i < n-1){
                l++;
                r--;
            }else{
                l--;
                r++;
            }
        }
    }
}
