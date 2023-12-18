package workbook_0x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 애너그램만들기_1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int[] alphabet1 = new int[26];
        int[] alphabet2 = new int[26];

        for(int i = 0 ; i< str1.length() ; i++){
            char c1 = str1.charAt(i);
            alphabet1[c1-'a']++;
        }
        for(int i = 0 ; i< str2.length() ; i++){
            char c2 = str2.charAt(i);
            alphabet2[c2-'a']++;
        }
        int ans = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(alphabet1[i] != alphabet2[i]){
                ans+=Math.abs(alphabet1[i]-alphabet2[i]);
            }
        }
        System.out.println(ans);
    }
}
