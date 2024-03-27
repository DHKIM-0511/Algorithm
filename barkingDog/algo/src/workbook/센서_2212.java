package workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 센서_2212 {
    static int n,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        if (k >= n) {
            System.out.println(0);
            return;
        }

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++)arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        Integer[] diff = new Integer[n-1];
        for(int i =0 ; i < n-1 ; i++){
            diff[i] = arr[i+1] - arr[i];
        }
        Arrays.sort(diff,Collections.reverseOrder());

        int sum = 0;
        for(int i = k-1; i < n-1; i++) sum += diff[i];
        System.out.println(sum);

    }
}
