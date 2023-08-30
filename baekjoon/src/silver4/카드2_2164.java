package silver4;

import java.util.LinkedList;
import java.util.Scanner;

public class 카드2_2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(card(n)); 
		
	}

	private static int card(int n) {
		
		LinkedList<Integer> card = new LinkedList<>();
		for(int i = 0 ; i < n ; i++)
			card.offer(i+1);
		
		while(card.size()!=1) { // 카드가 한장남을때까지 반복
			card.poll();
			int a = card.poll();
			card.offer(a);
		}
		
		return card.poll(); // 마지막 한장 리턴
	}
}
