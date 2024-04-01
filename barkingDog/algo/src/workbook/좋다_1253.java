package workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다_1253 {
    static int n;
    static int[] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        input = new int[n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i = 0 ; i <n ; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        int cnt =0;
        for(int i = 0 ; i< n ; i++){

            int l = 0;
            int r = n-1;
            while (l < r){
                if(i == l){
                    l ++;
                    continue;
                }
                if(i == r){
                    r --;
                    continue;
                }

                int tmp = input[l] + input[r];

                if(tmp == input[i]){
                    cnt++;
                    break;
                }

                if(tmp < input[i]) l++;
                else r--;
            }
        }
        System.out.println(cnt);

    }
}
