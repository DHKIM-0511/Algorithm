package workbook_0x14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ListofUniqueNumbers_13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++) a[i] = Integer.parseInt(st.nextToken());

        boolean[] b= new boolean[100005];
        b[a[0]] = true;
        int r = 0;
        long cnt = 0;
        for(int l = 0 ; l < n; l++){
            while (r <n-1 && !b[a[r+1]]){
                r++;
                b[a[r]]=true;
            }
            cnt += (r-l+1);
            b[a[l]] =false;
        }
        System.out.println(cnt);
    }
}
