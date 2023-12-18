package solutions_0x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알파벳개수_10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] alphabet = new int[26];

        char[] arr = input.toCharArray();
        for(char c : arr){
            alphabet[c-'a']++;
        }

        for(int i : alphabet){
            System.out.print(i+" ");
        }
    }
}
