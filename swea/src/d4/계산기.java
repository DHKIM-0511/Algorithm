package d4;

import java.util.Scanner;
import java.util.Stack;

public class 계산기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int tc=1; tc<= T; tc++) {
			int N = sc.nextInt();
			String exp = sc.next(); // 중위표기식
			String converted  = ""; // 후위표기식
			
			// 1. 후위 표기식으로 바꾸기
			Stack<Character> s = new Stack<>(); // 연산자 스택
			for(int i=0; i<N; i++) {
				char c = exp.charAt(i);

				if(c=='*') { // * 연산자라면
					if(s.isEmpty()) s.push(c); // 스택이 비어있다면
					else if(s.peek() == '+') s.push(c);
					else if(s.peek() == '*') {
						converted += s.pop();
						s.push(c);
					}
				
				} else if(c == '+') { // + 연산자라면
					
					if(s.isEmpty()) s.push(c);
					else if(s.peek() == '+') {
						converted += s.pop();
						s.push(c);
					} else if(s.peek() == '*') {
						while(!s.isEmpty() && s.peek() == '*') {
							converted += s.pop();
						}
						if(!s.isEmpty() && s.peek() == '+') {
							converted += s.pop();
						}
						s.push(c);
					}
					
					
				} else if(c-'0' >= 0 && c-'0' <= 9) { // 피연산자라면
					converted += c;
				} else if(c == '(') {
					s.push(c);
				} else if(c == ')') {
					while(s.peek() != '(') {
						converted += s.pop();
					}
					s.pop();
				}
			}
			// 스택에 연산자가 남아있는 경우 비워줘야 함
			while(!s.isEmpty())
				converted += s.pop();
			
			// 2. 후위표기식 계산
			Stack<Integer> s2 = new Stack<>();
			for(int i=0; i<converted.length(); i++) {
				char c = converted.charAt(i);
				if(c -'0' >= 0 && c - '0' <= 9) { // 숫자문자이면
					s2.push(c - '0'); // 피연산자라면
				} else if( c == '+') { // 연산자라면
					int num1 = s2.pop();
					int num2 = s2.pop();
					s2.push(num2 + num1);
				} else if( c== '*') {
					int num1 = s2.pop();
					int num2 = s2.pop();
					s2.push(num2 * num1);
				}
			}
			
			System.out.println("#"+tc+ " "+s2.pop());
		}
	}
}
