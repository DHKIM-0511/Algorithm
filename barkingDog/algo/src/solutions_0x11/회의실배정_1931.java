package solutions_0x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 회의실배정_1931 {
    static int N,ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] input = new int[N][2];
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            input[i][0] = start;
            input[i][1] = end;
        }

        Arrays.sort(input, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        int curEnd = 0;
        for(int[] i : input){
            if(curEnd > i[0]) continue;
            ans++;
            curEnd = i[1];
        }
        System.out.println(ans);
    }
}
