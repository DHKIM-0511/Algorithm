package silver5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 나이순정렬_10814 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		String[][] AN = new String[n][2];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			AN[i][0] = st.nextToken();
			AN[i][1] = st.nextToken();			
		}
		
		Arrays.sort(AN, new Comparator<String[]>() {
			@Override
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0])-Integer.parseInt(s2[0]);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i< n ; i++) {
			sb.append(AN[i][0]).append(" ").append(AN[i][1]).append("\n");
		}
		System.out.println(sb);
		
	}
}
