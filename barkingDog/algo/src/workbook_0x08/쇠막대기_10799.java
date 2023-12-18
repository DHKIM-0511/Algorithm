package workbook_0x08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 쇠막대기_10799 {
 public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     String input = br.readLine();
     Stack<Character> stack = new Stack<>();
     int ans = 0;
     for(int i = 0 ; i < input.length() ; i++){
        char c = input.charAt(i);

         if(c == '('){
             stack.push(c);
         }else{
             stack.pop();
             if(input.charAt(i-1) == '('){
                 //레이저
                 ans += stack.size();
             }else{
                 //쇠 끝점
                 ans++;
             }
         }
     }
     System.out.println(ans);
 }
}
