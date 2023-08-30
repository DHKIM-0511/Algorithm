package silver1;

import java.io.*;
import java.util.*;

public class 가장가까운세사람의심리적거리_20530_better {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(in.readLine());
		
		for (int tc = 0; tc < testCase; tc++) {
			int studentNum = Integer.parseInt(in.readLine());
			String[] students = new String[studentNum];
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			for (int idx = 0; idx < students.length; idx++)
				students[idx] = st.nextToken();
			
			// 학생의 수가 33명 이상인 경우 같은 MBTI가 3개 이상 존재하므로 0을 출력
			if (studentNum > 32) {
				out.write(0 + "\n");
				
			// 학생의 수가 32명 이하인 경우
			} else {
				
				// 최소 심리적 거리를 저장할 변수 minDistance 초기화
				int minDistance = Integer.MAX_VALUE;
				
				outer: for (int student1 = 0; student1 < students.length - 2; student1++) {
					for (int student2 = student1 + 1; student2 < students.length - 1; student2++) {
						for (int student3 = student2 + 1; student3 < students.length; student3++) {
							
							// 세 학생 간의 심리적 거리를 저장할 변수 distance 초기화
							int distance = 0;
							
							for (int idx = 0; idx < 4; idx++) {
								
								if (students[student1].charAt(idx) != students[student2].charAt(idx))
									distance++;
								if (students[student2].charAt(idx) != students[student3].charAt(idx))
									distance++;
								if (students[student1].charAt(idx) != students[student3].charAt(idx))
									distance++;
							}
							
							// 세 학생 간의 심리적 거리가 0인 경우 최소 심리적 거리 갱신 후 반복문 탈출
							if (distance == 0) {
								minDistance = 0;
								break outer;
							}
							minDistance = Math.min(distance, minDistance);
						}
					}
				}
				out.write(minDistance + "\n");
			}
		}
		in.close();
		out.close();
	}
}