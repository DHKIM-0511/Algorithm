package solutions_0x13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class 좌표압축_18870 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a = new int[n];
        for(int i = 0 ; i < n ; i++) a[i] = Integer.parseInt(st.nextToken());

        int[] b = IntStream.of(a).distinct().sorted().toArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            int idx = Arrays.binarySearch(b,a[i]);
            sb.append(idx).append(" ");
        }
        System.out.println(sb);
    }
}
