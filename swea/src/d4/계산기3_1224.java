package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 계산기3_1224 {
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
			
			Map<Character, Integer> rank = new HashMap<>(); //우선순위
			rank.put('+', 1);
			rank.put('*', 2);
			

			String postfix = ""; // 출력문 = 후위 표기
			Stack<Character> tmp = new Stack<>(); // 연산자 저장 스택

			for(char c : str.toCharArray()) {
				if(Character.isDigit(c)) { // 피연산자 출력문에 저장
					postfix += c;
				}else if(c == '+' || c == '*') { // 연산자 이면
					// top값이 ( 가 아닌 경우 우선순위 비교
					
					// stack이 [ ( * ] 이고 현위치 + 인 경우 처음에 * 를 pop하고 다시 반복문 비교할때  (를 비교하게되는 에러
					while(!tmp.isEmpty() && tmp.peek()!='(' &&rank.get(tmp.peek())>=rank.get(c)) {
						// tmp가 비어있지 않고 , 현재 연산자 우선순위가 top보다 낮으면 스택에서 꺼내서 출력
						postfix+=tmp.pop();
					}
					tmp.push(c); // 아니면 푸시
					
				}else if(c=='(') { // ( 연산 저장
					tmp.push(c);
				}else if(c==')'){
					while(tmp.peek() != '(') {
						postfix+=tmp.pop();
					}
					tmp.pop(); // ( 연산 제거
				}
			}
			while(!tmp.isEmpty()) { // 스택에 남은 연산자 출력문에 더해주기
				postfix+=tmp.pop();
			}

			Stack<Integer> dum = new Stack<>();	// 피 연산자 스택
			
			for(int i = 0 ; i < postfix.length() ; i++) {
				char q = postfix.charAt(i);
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
