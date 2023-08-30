package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class T {
	static int n,m;
	static int[] tree;
	static int max=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //나무 수
		m = Integer.parseInt(st.nextToken()); // 가져가려는 나무 길이.
		
		tree = new int[n]; // 나무 높이의 합 >= m
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < n ; i ++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = max < tree[i] ? tree[i] : max ;
		}
		long start = System.nanoTime();
		System.out.println(binarySearch());
		long end = System.nanoTime();
//		System.out.println(end-start);
	}
	private static long binarySearch() {
		
		long left = 0 ;
		long right = max;
		
		while(left <= right) { //
			long mid = (left + right) / 2;	
			
			long length = 0 ;
			
			for(int i = 0 ; i < tree.length ; i++) {
				if(tree[i] - mid > 0 ) {
					length += (tree[i] -mid);
				}
			}
			
			if( length >= m){
				left = mid+1; // 오른쪽 구간
			}else
				right = mid-1;
			System.out.println("left :" +left);
			System.out.println("right :" +right);
		}
		
		
		return right;
	}
}
