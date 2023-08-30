package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 너의평점은_25206 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double sum = 0;
		double cnt = 0;
		
		for(int i = 0 ; i < 20 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken(); // 과목명
			double grade = Double.parseDouble(st.nextToken()); // 학점
			String a = st.nextToken(); // 과목평점
			double tmp = 0;
			
			if(!a.equals("P")) {
				cnt += grade;
			}
			if(a.equals("A+")) {
				tmp = 4.5;
			}else if(a.equals("A0")) {
				tmp = 4.0;
			}else if(a.equals("B+")) {
				tmp = 3.5;
			}else if(a.equals("B0")) {
				tmp = 3.0;
			}else if(a.equals("C+")) {
				tmp = 2.5;
			}else if(a.equals("C0")) {
				tmp = 2.0;
			}else if(a.equals("D+")) {
				tmp = 1.5;
			}else if(a.equals("D0")) {
				tmp = 1.0;
			}else if(a.equals("F")) {
				tmp = 0.0;
			}
			
			sum += grade * tmp;
			
		}
		
		System.out.println(sum/cnt);
	}
}
