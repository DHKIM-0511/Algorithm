package workbook_0x0F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 먹을것인가먹힐것인가_7795_ans {
    static int A,B;
    static int[] Anums;
    static int[] Bnums;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            Anums = new int[A];
            Bnums = new int[B];

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<A; i++){
                Anums[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<B; i++){
                Bnums[i] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            Arrays.sort(Bnums); // 정렬
            for (int i=0; i<A; i++){
                cnt += find(Anums[i], Bnums);
            }

            sb.append(cnt).append("\n");
        } // end of tc

        System.out.println(sb);
    }

    private static int find(int num, int[] Bnums){
        int start = 0;
        int end = Bnums.length;

        while( start < end) {
            int mid = (start + end) / 2;

            if ( Bnums[mid] < num ){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
