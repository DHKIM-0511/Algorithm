package workbook_0x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 선긋기_2170 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        List<int[]> line = new ArrayList<>();
        while (N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) + 1000000000;
            int r = Integer.parseInt(st.nextToken()) + 1000000000;

            line.add(new int[]{l,1});// 선분 시작
            line.add(new int[]{r,-1});// 선분 끝
        }

        Collections.sort(line, (o1, o2) -> o1[0]- o2[0]);

        int cnt = 0;
        int total = 0;
        int loc = Integer.MIN_VALUE;
        for(int[] i : line){
            if( cnt > 0 ) total += i[0] - loc; // 선과 선 사이는 제외되는 조건
            loc = i[0];
            cnt += i[1];
        }
        System.out.println(total);
    }
}
