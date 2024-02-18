package workbook_0x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class 멀티버스Ⅱ_18869 {
    static int n,m;
    static int[][] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        a = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
            compress(a[i]);
        }

        int cnt = 0;
        for(int i = 0 ; i < m-1 ; i++){
            for(int j = i+1 ; j < m ; j++){
                if(check(a[i], a[j])) cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void compress(int[] a) {
        int[] copy = new int[n];
        for(int i = 0 ;  i < n ; i++) copy[i] = a[i];
        copy = IntStream.of(copy).distinct().sorted().toArray();

        for(int i = 0 ; i < n ; i++){
            a[i] = Arrays.binarySearch(copy,a[i]);
        }
    }

    private static boolean check(int[] a, int[] b) {
        for(int i = 0 ; i < n ; i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }
}
