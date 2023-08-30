package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class 계산기2_1223 {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        for(int tc = 1 ; tc <= 10 ; tc++) {
            int n = Integer.parseInt(br.readLine());
            String str =br.readLine();
            System.out.println("#"+tc+" "+calc(str));
        }
    }
 
    private static int calc(String str) {
        int ans = 0;
        
        Map<Character, Integer> rank = new HashMap<>(); // 연산자 우선순위 설정
        rank.put('+', 1);
        rank.put('*', 2);
         
        String sb = ""; // 출력문 = 후위표기
        Stack<Character> tmp = new Stack<>(); // 연산자 저장 스택
        
         
        for(char c : str.toCharArray()) {
            if(Character.isDigit(c)) { // 후위표기식에 숫자는 바로 저장
                sb+=c;
                
            }else if(c == '+' || c == '*') { // 연산자 이면 
                while(!tmp.isEmpty() && rank.get(tmp.peek())>=rank.get(c)) {// tmp가 비어있지 않고 , 
                    //현재 연산자 우선순위가 top보다 낮으면 
                	//즉 탑이(스택) 우선순위가 높은상태면
                	//즉 현검사 위치가 낮으면
                    sb+=tmp.pop(); // 스택에서 꺼내서 출력
                    
                }
                tmp.push(c); // 아니면 스택에 저장
            }
        }
         
        while(!tmp.isEmpty()) { // 스택에 남은 연산자를 출력문에 더해주기
            char a = tmp.pop();
            sb+=a;
            
        }
        
        Stack<Integer> dum = new Stack<>(); // 피 연산자 스택
        
        for(int i = 0 ; i < sb.length() ; i++) {
            char q = sb.charAt(i);
            if(Character.isDigit(q)) {
                dum.push(q-'0');
            }else if (q =='+' || q== '*') {
                if(q=='+') {
                    int a = dum.pop();
                    int b = dum.pop();
                    dum.push(a+b);
                }else if(q=='*') {
                    int a = dum.pop();
                    int b = dum.pop();
                    dum.push(a*b);
                }
                 
            }
        }
        ans = dum.pop();
        return ans;
    }
}
