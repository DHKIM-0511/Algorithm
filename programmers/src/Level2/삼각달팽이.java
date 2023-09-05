package Level2;

import java.util.*;

public class 삼각달팽이 {
	class Solution {
		public int[] solution(int n) {
			//등차 수열 합 공식
			int size = (n * (n + 1)) / 2;
			int[] answer = new int[size];
			//삼각형태로 넣을 2차원 배열
			int[][] map = new int[n][n];

			int r = -1, c = 0;
			int num = 1;

			//⬇➡↖ 규칙을 가지고 n, n-1, n-2 ... 번 자연수 주입
			for (int i = 0; i < n; i++) {
				for (int j = i; j < n; j++) {
					if (i % 3 == 0) {
						r++;
					} else if (i % 3 == 1) {
						c++;
					} else if (i % 3 == 2) {
						r--;
						c--;
					}
					map[r][c] = num++;
				}
			}

			int k = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 0)
						break;
					answer[k++] = map[i][j];
				}
			}

			return answer;
		}
	}
}
