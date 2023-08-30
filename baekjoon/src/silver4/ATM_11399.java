package silver4;

import java.util.PriorityQueue;
import java.util.Scanner;

public class ATM_11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i = 0 ; i < n ; i++) {
			q.offer(sc.nextInt());
		}
		int[] num = new int[n];
		int sum = 0 ;
		
		for(int i = 0 ; i < n ; i++) {
			int tmp = q.poll();
			sum+=tmp;
			num[i] = sum;
		}
		
		sum = 0;
		for(int a : num) {
			sum+=a;
		}
		System.out.println(sum);
	}
}
