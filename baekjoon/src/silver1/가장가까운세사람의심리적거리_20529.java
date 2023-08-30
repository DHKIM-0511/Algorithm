package silver1;

import java.io.*;
import java.util.*;

public class 가장가까운세사람의심리적거리_20529 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			List<String> studentList = new ArrayList<String>();
			
			for (int i = 0; i < N; i++) studentList.add(st.nextToken());
			
			int min = Integer.MAX_VALUE;
			
			out : for (int i = 0; i < studentList.size(); i++) {
				for (int j = i+1; j < studentList.size(); j++) {
					for (int k = j+1; k < studentList.size(); k++) {
						min = Math.min(min, getDistance(studentList.get(i), studentList.get(j), studentList.get(k)));
					    if(min == 0) break out;
                    }
				}
			}
			System.out.println(min);
		}
	}
	private static int getDistance(String student1, String student2, String student3) {
		int sum = 0;
		sum += distance(student1, student2);
		sum += distance(student2, student3);
		sum += distance(student1, student3);
		return sum;
	}
	private static int distance(String student1, String student2) {
		int sum = 0;
		for(int i = 0 ; i < 4; i++) { 
			if(student1.charAt(i) != student2.charAt(i)) sum++;
		}
		return sum;
	}
}
