package d3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 햄버거다이어트_5215 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= t ;tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int maxCal = Integer.parseInt(st.nextToken());
			
//			int[] score = new int[n];
//			int[] Cal = new int[n];
//			int[] sPc = new int[n];
//			
//
//			
//			for(int i = 0 ; i < n ; i++) {
//				st = new StringTokenizer(br.readLine());
//				score[i] = Integer.parseInt(st.nextToken());
//				Cal[i] = Integer.parseInt(st.nextToken());
//				sPc[i] = score[i] / Cal[i];
//			}
			
//			for(int i = 0 ; i < n ; i++) {
//			for(int j = 0 ; j < n ; j++) {
//				
//				if(calSum <= maxCal) {
//					scoreSum += score[j];
//					calSum += Cal[j];
//				}
//				
//			}	
			
			double[][] hamburgers = new double[n][2];
			
			for(int i = 0 ; i < n ; i++) {
				st = new StringTokenizer(br.readLine());
				hamburgers[i][0] = Double.parseDouble(st.nextToken());
				hamburgers[i][1] = Double.parseDouble(st.nextToken());
			}
			
			int scoreSum = 0;
			int calSum = 0;
			Arrays.sort(hamburgers, (o1, o2) -> {
				return Double.compare(o2[0] / o2[1], o1[0] / o1[1]);
			});
			
//			for (double[] hamburger : hamburgers) {
//				System.out.println(Arrays.toString(hamburger));
//			}
			
			for(int i = 0 ; i < n ;i++) {
				if(calSum+hamburgers[i][1] <= maxCal) {
					scoreSum += (int)hamburgers[i][0];
					calSum += (int)hamburgers[i][1];	
				}
			}
			System.out.println("#"+tc+" "+scoreSum);
		}
	}
}
