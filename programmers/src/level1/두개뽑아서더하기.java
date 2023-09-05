package level1;

import java.util.*;

public class 두개뽑아서더하기 {
	public class Solution {
		public int[] solution(int[] numbers) {
			Set<Integer> set = new TreeSet<>();

			for (int i = 0; i < numbers.length - 1; i++) {
				for (int j = i + 1; j < numbers.length; j++) {
					set.add(numbers[i] + numbers[j]);
				}
			}
			int[] answer = new int[set.size()];
			int index = 0;
			for (int num : set) {
				answer[index++] = num;
			}
			return answer;
		}
	}
}