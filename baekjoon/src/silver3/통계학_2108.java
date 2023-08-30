package silver3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 통계학_2108{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		double Avg = 0;
		int max = -4000;
		int min = 4000;
		int r = 0;
		
		int[] cnt = new int[8001];
		int[] num = new int[n];
		
 		for(int i = 0 ; i < n ; i++) {
			num[i] = Integer.parseInt(br.readLine());
			Avg += num[i];
			cnt[num[i]+4000]++;
			
			if(max < num[i]) {
				max = num[i];
			}
			if(min > num[i]) {
				min = num[i];
			}
			
		}
		
		//중앙값
 		Arrays.sort(num);
		int mid = num[n/2];
		
		//최빈값
		int maxCnt = 0;
		int mode = 0;
		List<Integer> cntlist = new ArrayList<>();
		
		for(int i = 0 ; i < 8001 ; i++) {
			if( maxCnt < cnt[i]) {
				maxCnt = cnt[i];
				mode = i - 4000;
				cntlist.clear();
				cntlist.add(i-4000);
			}else if(maxCnt == cnt[i]) {
				cntlist.add(i-4000);
			}
		}
		
		if(cntlist.size() > 1 ) {
			mode = cntlist.get(1);
		}
		
		r= Math.abs(max - min);
		
		
		sb.append(Math.round(Avg/n)).append('\n').append(mid).append('\n').append(mode).append('\n').append(r);
		System.out.println(sb);
		
		
		
	}
}