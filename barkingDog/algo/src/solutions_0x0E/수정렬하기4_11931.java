package solutions_0x0E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기4_11931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] countArr = new boolean[2000005];

        while (N-- > 0){
            int cur = Integer.parseInt(br.readLine());
            countArr[cur+1000000] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = countArr.length-1 ; i >= 0 ; i--){
            if(countArr[i]) sb.append(i-1000000).append("\n");
        }
        System.out.println(sb);
    }
}
