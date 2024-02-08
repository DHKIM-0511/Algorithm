package workbook_0x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 멀티탭스케줄링_1700 {
    static int N,K;
    static int[] a = new int[105]; // 전기용품의 사용 순서
    static boolean[] power = new boolean[105]; // 해당 전기용품이 멀티탭에 꽂혀 있는가?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 멀티탭 구멍의 개수
        K = Integer.parseInt(st.nextToken()); // 전기용품의 총 사용 횟수
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++) {
            a[i] = Integer.parseInt(st.nextToken()); // 전기용품의 사용 순서 입력 받기
        }

        int ans = 0; // 플러그를 빼고 꽂는 최소 횟수
        int cnt = 0; // 멀티탭에 꽂혀 있는 전기용품의 개수
        for (int i = 1; i <= K; i++) {
            int cur = a[i];
            if (power[cur]) continue; // 이미 꽂혀 있으면 넘어감
            if (cnt < N) { // 멀티탭에 자리가 남으면 그냥 꽂음
                power[cur] = true;
                cnt++;
            } else {
                ArrayList<int[]> idx = new ArrayList<>();

                for (int x = 1; x <= K; x++) {
                    if (!power[x]) continue;

                    boolean vis = false;
                    for (int y = i + 1; y <= K; y++) {
                        if (a[y] == x) {//꽂혀있는것중 a배열에서 가장 먼것을 찾음
                            idx.add(new int[]{y, x});
                            vis = true;
                            break;
                        }
                    }
                    if (!vis) idx.add(new int[]{K + 1, x}); // a에서 나오지 않으면 k + 1로 처리
                }
                idx.sort((p1, p2) -> p2[0] - p1[0]);
                int target = idx.get(0)[1]; // 가장 늦게 사용할 전기용품을 뽑고 cur을 꽂으면 됨
                power[target] = false;
                ans++;
                power[cur] = true;
            }
        }
        System.out.println(ans);
    }
}
