package workbook_0x0F;

import java.util.Arrays;
import java.util.Scanner;

public class 역원소정렬_5648 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =  sc.nextInt();
        long[] input = new long[N];

        for(int i = 0 ; i < N ; i++){
            String str = sc.next();
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            input[i] = Long.parseLong(sb.toString());
        }
        Arrays.sort(input);

        StringBuilder sb = new StringBuilder();
        for(long l : input) sb.append(l).append("\n");
        System.out.println(sb);
    }
}
