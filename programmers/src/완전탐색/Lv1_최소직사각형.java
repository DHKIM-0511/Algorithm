package 완전탐색;

public class Lv1_최소직사각형 {
	//sizes = 명함들의 가로 세로 길이 / {w , h}
	//명함지갑 크기의 최소값을 구해라
	public int solution(int[][] sizes) {
		int w = 0 , h = 0;
		
		for(int[] size : sizes) {
			//w + h = z일때
			//넓이 = w * (z-w) = (zw - w^2) -(미분)-> z-2w = 0일때 최대 , w = z/2
			//즉 w,h가 같을수록 값이 커지고 , 차이가 클 수 록 값이 최소
			//따라서 w는 최대값 저장, h는 최소값 저장
			int width = Math.max(size[0], size[1]);
			int height = Math.min(size[0], size[1]);
			
			w = Math.max(width, w);
			h = Math.max(height, h);
		}
		return w*h;
	}
}
