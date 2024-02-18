package solutions_0x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 세수의합_2295 {
    static int n;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        for(int i= 0 ; i < n ; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(a);

        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                list.add(a[i] + a[j]);
            }
        }
        Collections.sort(list);

        for(int i = n-1 ; i >= 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if(Collections.binarySearch(list, a[i] - a[j]) >=0){
                    System.out.println(a[i]);
                    return;
                }
            }
        }
    }
}
