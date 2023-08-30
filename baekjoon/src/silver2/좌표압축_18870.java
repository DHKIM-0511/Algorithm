package silver2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 좌표압축_18870 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] X = new int[N];	
		int[] sortedX = new int[N];	
 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(st.nextToken());
			sortedX[i] = x;
			X[i] = x; 
		}
		
		
		Arrays.sort(sortedX); // 배열 정렬
		
		HashMap<Integer, Integer> rankingMap = new HashMap<Integer, Integer>();	
		
		int rank = 0;
		for(int v : sortedX) {
			if(!rankingMap.containsKey(v)) { // 중복값은 넣지 않음
				rankingMap.put(v, rank);
				rank++;		
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int key : X) {
			int ranking = rankingMap.get(key);
			sb.append(ranking).append(' ');
		}
		
		System.out.println(sb);
		
	
	}
}
