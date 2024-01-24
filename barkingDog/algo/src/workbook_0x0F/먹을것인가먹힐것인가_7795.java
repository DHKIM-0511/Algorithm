package workbook_0x0F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 먹을것인가먹힐것인가_7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc = 0 ; tc < T ; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Integer[] a = new Integer[A];
            Integer[] b = new Integer[B];

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < A; i++) a[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < B; i++) b[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(b);
            int ans = 0;
            for(int i = 0 ; i < A ; i++){
                ans += find(a[i],b);
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static int find(int target, Integer[] b) {
        int left = 0;
        int right = b.length;

        while (left < right){
            int mid = (left+right)/2;

            if(b[mid] < target){
                left = mid +1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
