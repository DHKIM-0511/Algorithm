package workbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 두배열의합_2143 {
    static int t,n,m;
    static int[] a,b,sumA,sumB;
    static List<Long> listA, listB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        a = new int[n+1];
        sumA = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            a[i] = Integer.parseInt(st.nextToken());
            sumA[i] = sumA[i-1] + a[i];
        }

        m = Integer.parseInt(br.readLine());
        b = new int[m+1];
        sumB = new int[m+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= m ; i++){
            b[i] = Integer.parseInt(st.nextToken());
            sumB[i] = sumB[i-1] + b[i];
        }
        listA = new ArrayList<>();
        listB = new ArrayList<>();
        for(int i = 1; i <= n ; i++){
            for(int j = 0 ; j< i ; j++){
                listA.add((long)sumA[i]-sumA[j]);
            }
        }

        for(int i = 1; i <= m ; i++){
            for(int j = 0 ; j< i ; j++){
                listB.add((long)sumB[i]-sumB[j]);
            }
        }

        Collections.sort(listA);
        Collections.sort(listB);
        long cnt = 0;
        for(int i =0 ; i< listA.size() ; i++){
            long target = t - listA.get(i);
            cnt += upperBound(target) - lowerBound(target);
        }
        System.out.println(cnt);
    }

    private static int upperBound(long target) {
        int l =0;
        int r = listB.size();
        while (l < r){
            int mid = (l+r)/2;
            if(target >= listB.get(mid)){
                l = mid+1;
            }else {
                r = mid;
            }
        }
        return l;
    }
    private static int lowerBound(long target){
        int l =0;
        int r = listB.size();
        while (l < r){
            int mid = (l+r)/2;
            if(target <= listB.get(mid)){
                r = mid;
            }else {
                l = mid+1;
            }
        }
        return l;
    }
}
