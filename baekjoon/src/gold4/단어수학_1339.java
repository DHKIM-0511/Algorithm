package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 단어수학_1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] alpha = new int[26];
        
        for (int x = 0; x < N; x++) {
            String tmp = br.readLine();

            int size = tmp.length();

            int base = (int) Math.pow(10, size - 1);

            for (int i = 0; i < size; i++) {
                alpha[tmp.charAt(i) - 'A'] += base;
                base /= 10;
            }
        }
        Arrays.sort(alpha);
        
        int ans = 0;
        for (int i = 25; i >= 17; i--) {
            ans += alpha[i] * (i - 16);
        }
        System.out.println(ans);
    }
}
