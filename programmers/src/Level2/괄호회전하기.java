package Level2;

import java.util.*;

public class 올바른괄호 {
	class Solution {

		public int solution(String s) {
			int answer = 0;
			int size = s.length();
			char[] input = s.toCharArray();
			Deque<Character> dq = new ArrayDeque<>();
			for (char c : input) {
				dq.addLast(c);
			}
			for (int i = 0; i < size; i++) {
				//회전 처리
				if (i > 0) {
					char c = dq.pollFirst();
					dq.addLast(c);
				}
				Deque<Character> check = new ArrayDeque<>(dq);

				//올바른지 판별
				if (isOk(check)) {
					answer++;
				}
			}

			return answer;
		}

		public boolean isOk(Deque<Character> dq) {
			Stack<Character> stack = new Stack<>();

			// System.out.println(dq);
			while (!dq.isEmpty()) {
				char cur = dq.pollFirst();
				// System.out.println(cur);
				if (cur == '[' || cur == '{' || cur == '(') {
					stack.push(cur);
				} else if (cur == ']') {
					if (stack.isEmpty()) {
						return false;
					} else {
						char c = stack.pop();
						if (c != '[')
							return false;
					}
				} else if (cur == '}') {
					if (stack.isEmpty()) {
						return false;
					} else {
						char c = stack.pop();
						if (c != '{')
							return false;
					}
				} else if (cur == ')') {
					if (stack.isEmpty()) {
						return false;
					} else {
						char c = stack.pop();
						if (c != '(')
							return false;
					}
				}
			}

			if (!stack.isEmpty())
				return false;

			return true;
		}
	}
}
