package workbook_0x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Strfry_11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        out: for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();

            int[] alphabet1 = new int[26];
            int[] alphabet2 = new int[26];

            if(str1.length() != str2.length()){
                System.out.println("Impossible");
                continue;
            }

            for(int j = 0 ; j < str1.length() ; j++){
                char c = str1.charAt(j);
                alphabet1[c-'a']++;
            }

            for(int j = 0 ; j < str2.length() ; j++){
                char c = str2.charAt(j);
                alphabet2[c-'a']++;
            }

            for(int j = 0 ; j< 26 ; j++){
                if(alphabet1[j] != alphabet2[j]){
                    System.out.println("Impossible");
                    continue out;
                }
            }
            System.out.println("Possible");
        }
    }
}
