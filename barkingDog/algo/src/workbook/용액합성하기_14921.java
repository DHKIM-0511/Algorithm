package workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용액합성하기_14921 {
    static int n;
    static int[] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        input = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i <n ; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0 ;
        int r = n-1;
        int sum=Integer.MAX_VALUE;
        while (l < r){
            int tmp = input[l] + input[r];

            if( tmp == 0){
                System.out.println(0);
                return;
            }

            if(Math.abs(tmp) < Math.abs(sum)){
                sum = tmp;
            }

            if(tmp > 0) r--;
            else l++;
        }
        System.out.println(sum);
    }
}
